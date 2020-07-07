package telran.cars.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import telran.cars.domain.Car;
import telran.cars.domain.Driver;
import telran.cars.domain.Model;
import telran.cars.domain.RentRecord;
import telran.cars.dto.CarsReturnCode;
import telran.cars.dto.WrongArgumentException;

public class RentCompany extends AbstractRentCompany {
	private Map<String, Car> cars = new HashMap<>();
	private Map<Long, Driver> drivers = new HashMap<>(); 
	private Map<String, Model> models = new HashMap<>();
	private Map<String, List<RentRecord>> carRecords = new HashMap<>();
	private Map<Long, List<RentRecord>> driverRecords = new HashMap<>();
	private TreeMap<LocalDate, List<RentRecord>> returnedRecords = new TreeMap<>();

	@Override
	public CarsReturnCode addModel(Model model) {
		if (model == null) {
			throw new WrongArgumentException();
		}
		return models.putIfAbsent(model.getModelName(), model) == null ? CarsReturnCode.OK
				: CarsReturnCode.MODEL_EXISTS;
	}

	@Override
	public CarsReturnCode addCar(Car car) {
		Model model = models.get(car.getModelName());
		if (model == null) {
			return CarsReturnCode.NO_MODEL;
		}
		return cars.putIfAbsent(car.getRegNumber(), car) == null ? CarsReturnCode.OK 
				: CarsReturnCode.CAR_EXISTS;
	}

	@Override
	public CarsReturnCode addDriver(Driver driver) {
		return drivers.putIfAbsent(driver.getLicenseId(), driver) == null ? CarsReturnCode.OK
				: CarsReturnCode.DRIVER_EXISTS;
	}

	@Override
	public Model getModel(String modelName) {
		return models.get(modelName);
	}

	@Override
	public Car getCar(String regNumber) {
		return cars.get(regNumber);
	}

	@Override
	public Driver getDriver(long licenseId) {
		return drivers.get(licenseId);
	}

	@Override
	public CarsReturnCode rentCar(String regNumber, long licenseId, LocalDate rentDate, 
			int rentDays) {
		CarsReturnCode code = checkRentCar(regNumber, licenseId);
		if(CarsReturnCode.OK.equals(code)) {
			RentRecord record = new RentRecord(licenseId, regNumber, rentDate, rentDays);
			addCarRecords(record);
			addDriverRecords(record);
			setInUse(regNumber);
		}
		return code;
	}

	private void setInUse(String regNumber) {
		Car car = cars.get(regNumber);
		car.setInUse(true);	
	}

	private void addDriverRecords(RentRecord record) {
		long licenseId = record.getLicenseId();
		List<RentRecord> records = driverRecords.get(licenseId);
		if (records == null) {
			records = new ArrayList<>();
			driverRecords.put(licenseId, records);
		}
		records.add(record);
		
	}

	private void addCarRecords(RentRecord record) {
		String regNumber = record.getRegNumber();
//		List<RentRecord> records = carRecords.getOrDefault(regNumber, new ArrayList<>());
		List<RentRecord> records = carRecords.get(regNumber);
		if (records == null) {
			records = new ArrayList<>();
			carRecords.put(regNumber, records);
		}
		records.add(record);
		
	}

	private CarsReturnCode checkRentCar(String regNumber, long licenseId) {
		Car car = cars.get(regNumber);
		if (car == null || car.isFlRemoved()) {
			return CarsReturnCode.CAR_NOT_EXISTS;
		}
		if (car.isInUse()) {
			return CarsReturnCode.CAR_IN_USE;
		}
		if (!drivers.containsKey(licenseId)) {
			return CarsReturnCode.NO_DRIVER;
		}	
		return CarsReturnCode.OK;
	}

	@Override
	public CarsReturnCode returnCar(String regNumber, long licenseId, LocalDate returnDate, int gasTankPercent,
			int damages) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CarsReturnCode removeCar(String regNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> clear(LocalDate currentDate, int days) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Driver> getCarDrivers(String regNumber) {
		return carRecords.containsKey(regNumber) ?     //информация о водителях водивших автомобиль в мапе carRecords
				carRecords.get(regNumber).stream()     //делаем стрим рекордов из листа
				.map(r -> r.getLicenseId())            //получаем лицензии водителей 
				.distinct()                            //убираем дубликаты
				.map(l -> drivers.get(l))              //получаем объекты драйверов			                           
				.collect(Collectors.toList())          //собираю в лист
				: null;
				
	}

	@Override
	public List<Car> getDriverCars(long licenseId) {
		return driverRecords.containsKey(licenseId) ?          
				driverRecords.get(licenseId).stream()
				.map(r -> r.getRegNumber())
				.map(rn -> cars.get(rn))
				.distinct()
				.collect(Collectors.toList())
				: null;   //API - есть вариант вернуть NULL или пустой лист, правильно возвращать optional
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
		return carRecords.values()
				.stream()
				.flatMap(l -> l.stream());
	}

	@Override
	public List<String> getMostPopularModelNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getModelProfit(String modelName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> getMostProfitModelNames() {
		// TODO Auto-generated method stub
		return null;
	}

}
