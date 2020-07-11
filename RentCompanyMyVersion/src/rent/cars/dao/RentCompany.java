package rent.cars.dao;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import rent.cars.domain.Car;
import rent.cars.domain.Driver;
import rent.cars.domain.Model;
import rent.cars.domain.RentRecord;
import rent.cars.dto.CarsReturnCode;
import rent.cars.dto.State;

public class RentCompany extends AbstractRentCompany{
	
//==============================================fields
	private Map<String, Car> cars = new HashMap<>();  //создаю мапу машин
	private Map<Long, Driver> drivers = new HashMap<>(); //создаю мапу водителей
	private Map<String, Model> models = new HashMap<>(); //создаю мапу моделей
	private Map<String, List<RentRecord>> carRecords = new HashMap<>(); //создаю мапу записей аренд автомобилей
	private Map<Long, List<RentRecord>> driverRecords = new HashMap<>(); //создаю мапу записей водителей
	private TreeMap<LocalDate, List<RentRecord>> returnedRecords = new TreeMap<>(); //мапа записей возвратов
	
	
	
	
	@Override
	public CarsReturnCode addModel(Model model) {
		if(model == null) {                                //проверка, если модель null возврат кода ошибки
			return CarsReturnCode.INPUT_ERROR;
		}
		
		return models.putIfAbsent(model.getModelName(), model) == null?     //если модель не существует, добаляем
				CarsReturnCode.OK: CarsReturnCode.MODEL_EXIST;             //если существует, возвращаем соответсствующий код
	}

	
	
	@Override
	public CarsReturnCode addCar(Car car) {

		Model model = models.get(car.getModelName()); //возвращаем наименование модели объекта car и достаем его из мапы моделей
		if(model == null) {                           //если модели нет, возвращаем соответствующий код
			return CarsReturnCode.NO_MODEL;
		}
		
		return cars.putIfAbsent(car.getRegNumber(), car) == null?  //добавляем номер машины и объект car 
				CarsReturnCode.OK: CarsReturnCode.CAR_EXIST;       //в мапу cars
	}

	@Override
	public CarsReturnCode addDriver(Driver driver) {
		return drivers.putIfAbsent(driver.getLicenseID(), driver) == null?      //добавляем водителя в мапу drivers
				CarsReturnCode.OK: CarsReturnCode.DRIVER_EXIST;
	}

	@Override
	public Model getModel(String modelName) {
		return models.get(modelName);               //возврат объекта model по имени
	}

	@Override
	public Car getCar(String regNumber) {
		return cars.get(regNumber);                 //возврат объекта Car по номеру 
	}

	@Override
	public Driver getDriver(long licenseID) {
		return drivers.get(licenseID);             //возврат объекта driver по номеру лицензии
	}

	@Override              //сдача в аренду автомобиля
	public CarsReturnCode rentCar(String regNumber, long licenseID, LocalDate rentDate, int rentDays) {
		CarsReturnCode code = checkRentCar(regNumber, licenseID);  //проверка автомобиля для сдачи в аренду
		if(CarsReturnCode.OK.equals(code)) {
			RentRecord record = new RentRecord(licenseID, regNumber, rentDate, rentDate);
			addCarRecord(record);
			addDriverRecord(record);
			setInUse(regNumber);         //установка флага занято
		}
		return code;
	}




	private CarsReturnCode checkRentCar(String regNumber, long licenseID) {
		Car car = cars.get(regNumber);  //получаем объект
		if (car == null || car.isFlRemoved()) {
			return CarsReturnCode.CAR_NOT_EXIST;
		}
		if (car.isInUse()) {
			return CarsReturnCode.CAR_IN_USE;
		}
		if (!drivers.containsKey(licenseID)) {
			return CarsReturnCode.NO_DRIVER;
		}
		return CarsReturnCode.OK;
	}



	private void addCarRecord(RentRecord record) {
	
		String regNumber = record.getRegNumber();
//		List<RentRecord> records = carRecords.getOrDefault(regNumber, new ArrayList<>());
		List<RentRecord> records = carRecords.get(regNumber);
		if (records == null) {
			records = new ArrayList<>();
			carRecords.put(regNumber, records);
		}
		records.add(record);
	}
	

	private void addDriverRecord(RentRecord record) {
			long licenseId = record.getLicenseID();               //получаем номер прав
			List<RentRecord> records = driverRecords.get(licenseId);    //получаем список записей
			if(records == null ) {                             //если не было записей по водителю
				records = new ArrayList<>();                         //создаем новый лист
				driverRecords.put(licenseId, records);              //добавляем ключ и запись
			}
			records.add(record);                        //если запись была, добавляем запись 
		
	}



	private void setInUse(String regNumber) {           //установка флага занято
		Car car = cars.get(regNumber);               //получаем объект
		car.setInUse(true);                         //устанавливаем флаг
	}


	

	@Override
	public CarsReturnCode returnCar(String regNumber, long licenseID, LocalDate returnDate, int gasTankPercent,
			int damages) {
		RentRecord record = getRentRecord(regNumber, licenseID);                  //1
		CarsReturnCode code = checkReturnCar(regNumber, licenseID, returnDate, record);    //2
		if(code == CarsReturnCode.OK) {
			Car car = carSettings(regNumber,damages);                //3
			record.setReturnDate(returnDate);
			record.setDamages(damages);
			record.setGasTankPercent(gasTankPercent);
			Model model = models.get(car.getModelName());
			calcCosts(record,model);                                   //4
			List<RentRecord> records = returnedRecords.get(returnDate);
			if (records == null) {
				records = new ArrayList<>();
				returnedRecords.put(returnDate, records);
			}
			records.add(record);
		}
		return code;
	}

	
	
	
	//4
	private void calcCosts(RentRecord record, Model model) {        //вычисляем стоимость сделки
		double cost = record.getRentDays() * model.getPriceDay();   //основная стоимость cost = количество дней сделки * цену дня модели
		double gasCost = (100 - record.getGasTankPercent())/100.0*model.getGasTank()*gasPrice;  //стоимость долга за бензин
		LocalDate expextedReturnDate = record.getRentDate().plusDays(record.getRentDays()); //предпоагаемая дата возврата равна дате аренды плюс количество дней аренды
	    long delayDays = ChronoUnit.DAYS.between(expextedReturnDate, record.getReturnDate());  //вычисляем задержку в днях
	    double fineCost = delayDays * (100 + finePercent) / 100.0 * model.getPriceDay();
	    fineCost = fineCost >0 ? fineCost : 0;
	    record.setCost(cost + gasCost + fineCost); //суммируем стоимость со штрафами
	}



	//3
	private Car carSettings(String regNumber, int damages) {      //проверяем автомобиль на повреждения
		Car car = cars.get(regNumber);                 //получаем объект
		car.setInUse(false);                           //устанавливаем флаг автомобиля в неиспользуемый
		if(damages > 0 && damages < 10) {
			car.setState(State.GOOD);                  //если повреждения от 0 до 10 процентов - статус GOOD
		}
		if(damages > 10) {
			car.setState(State.BAD);                  
		}
		if(damages > 30) {
			car.setFlRemoved(true);                    //если повреждения больше 30 процентов - устанавливаем флаг к удалению
		}
		return car;
	}



	//2
	private CarsReturnCode checkReturnCar(String regNumber, long licenseID, LocalDate returnDate, RentRecord record) {
		if(drivers.get(licenseID) == null) {                 //проводятся проверки полученных значений 
			return CarsReturnCode.NO_DRIVER;
		}
		
		if(record == null) {      							 //и на основании из 
			return CarsReturnCode.CAR_NOT_RENTED;
		}
		
		
		if(returnDate.isBefore(record.getRentDate())) {      //возвращаются ответы
			return CarsReturnCode.RETURN_DATE_WRONG;
		}
		return CarsReturnCode.OK;                           //метод проверяет сдавался ли автомобиль в аренду этому водителю в эту дату
	}



	//1
	private RentRecord getRentRecord(String regNumber, long licenseID) {
		List<RentRecord> records = carRecords.get(regNumber); //получаем лист записей по номеру автомобиля
		return records == null ? null:       //проверяем на null
			records.stream()                 //и создаем стрим
			.filter(r -> r.getReturnDate() == null && r.getLicenseID() == licenseID)   //выбираем совпадающие записи
			.findFirst()                //возвращаем первого найденного
			.orElse(null);            //или null
	}



	@Override
	public CarsReturnCode removeCar(String regNumber) {    //метод помечает автомобиль к удалению
		Car car = cars.get(regNumber);
		if (car == null) {
			return CarsReturnCode.CAR_NOT_EXIST;
		}
		if (car.isInUse()) {
			return CarsReturnCode.CAR_IN_USE;
		}
		car.setFlRemoved(true);
		return CarsReturnCode.OK;
	}
	
	
	
	@Override
	public List<Car> clear(LocalDate currentDate, int days) {
		Set<String> victims = returnedRecords.headMap(currentDate.minusDays(days))
				.values().stream()
				.flatMap(l -> l.stream())
				.filter(r -> cars.get(r.getRegNumber()).isFlRemoved())
				.map(r -> r.getRegNumber())
				.collect(Collectors.toSet());     //собираем множество номеров автомобилей помеченных к удалению из returnRecords
		 
		List<Car> res = cars.entrySet().stream()
				.filter(e -> victims.contains(e.getKey()))
				.map(e -> e.getValue())
				.collect(Collectors.toList());    //собираем List номеров автомобилей из cars
		
		victims.forEach((vn -> {                  //в цикле удаляем автомобили из разных структур
			cars.remove(vn);                      //из cars
			carRecords.remove(vn);                //из carRecords
			driverRecords.values().stream()       //из driverRecords
				.forEach(lr -> lr.removeIf(r -> r.getRegNumber().equals(vn)));
			returnedRecords.values().stream()     //из returnRecords
				.forEach(lr -> lr.removeIf(r -> r.getRegNumber().equals(vn)));
		}));
		
		return res;
	}


	
	@Override
	public List<Driver> getCarDrivers(String regNumber) {  //возвращает водителей запрашиваемого автомобиля
		return carRecords.containsKey(regNumber) ?    //если carRecords содержит номер автомобиля
				carRecords.get(regNumber).stream()    //запускаем стрим
				.map(r -> r.getLicenseID())           //превращаем их в в права
				.map(l -> drivers.get(l))             //по которым получаем объекты водителей
				.distinct()                           //убираем дубли
				.collect(Collectors.toList())         //собираем в список
				:null;                    //или возвращаем null если записей нет
	}

	@Override
	public List<Car> getDriverCars(long licenseID) {      //метод возвращает список автомобилей, которые брал в аренду данный водитель
		return driverRecords.containsKey(licenseID) ?
				driverRecords.get(licenseID).stream()
				.map(r -> r.getRegNumber())
				.map(rn -> cars.get(rn))
				.distinct()
				.collect(Collectors.toList())
				:null;
	}

	
	
	@Override
	public Stream<Car> getAllCars() {
		return cars.values().stream();
	}

	@Override
	public Stream<Driver> getAllDrivers() {
		return drivers.values().stream();
	}

	@Override
	public Stream<RentRecord> getAllRecord() { 
		return carRecords.values().stream()
				.flatMap(l -> l.stream());
	}

	
//=========================================================================================	
	//такие задачи решаются в три этапа обычно
	//1) делается табличка - группируются данные (типа вхождения)
	//2) ищется максимум из профитов
	//3) выбать из моделей всех с профитом, равным максимуму
	
	
	
	@Override
	public List<String> getMostPopularModelNames() {                 //1
		Map<String, Long> modelFrequency = getAllRecord()
				.map(r -> cars.get(r.getRegNumber()).getModelName())    
				.collect(Collectors.groupingBy(n -> n, Collectors.counting()));
		
		long max = modelFrequency.values().stream()                  //2
				.max(Long::compare).orElse(0l);                 
		
		return modelFrequency.entrySet().stream()                    //3      
				.filter(e -> e.getValue() == max)
				.map(e -> e.getKey())
				.collect(Collectors.toList());
	}

	@Override
	public double getModelProfit(String modelName) {
		return getAllRecord()
				.filter(r -> cars.get(r.getRegNumber())
				.getModelName().equals(modelName))
				.mapToDouble(r -> r.getCost())
				.sum();
	}

	@Override
	public List<String> getMostProfitModelNames() {                              //1  получаю все записи и группирую
		Map<String, Double> modelsProfit = getAllRecord()                        
				.collect(Collectors.groupingBy(r -> cars.get(r.getRegNumber())
				.getModelName(), Collectors.summingDouble(r -> r.getCost())));
		
		double max = modelsProfit.values().stream()                              //2
				.max(Double::compare)
				.orElse(0.0);
		
		return modelsProfit.entrySet().stream()                                  //3
				.filter(e -> e.getValue() == max)
				.map(e -> e.getKey())
				.collect(Collectors.toList());
				
	}

}
