package telran.cars.dao;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import telran.cars.domain.Car;
import telran.cars.domain.Driver;
import telran.cars.domain.Model;
import telran.cars.domain.RentRecord;
import telran.cars.dto.CarsReturnCode;
import telran.cars.dto.State;
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
	public CarsReturnCode returnCar(String regNumber, long licenseId, LocalDate returnDate,
			int gasTankPercent,	int damages) {
		RentRecord record = getRentRecord(regNumber, licenseId);
		CarsReturnCode code = checkReturnCar(regNumber,licenseId, returnDate, record);		
		if(code == CarsReturnCode.OK) {
			Car car = carSettings(regNumber, damages);
			record.setReturnDate(returnDate);
			record.setDamages(damages);
			record.setGasTankPercent(gasTankPercent);
			Model model = models.get(car.getModelName());
			calcCosts(record,model);
			List<RentRecord> records = returnedRecords.get(returnDate);
			if(records == null) {
				records = new ArrayList<>();
				returnedRecords.put(returnDate, records);
			}
			records.add(record);
		}
		return code;
	}
	
	private void calcCosts(RentRecord record, Model model) {
		double cost = record.getRentDays() * model.getPriceDay();
		double gasCost = (100 - record.getGasTankPercent()) / 100.0 * model.getGasTank() * gasPrice;
		LocalDate expectedReturnDate = record.getRentDate().plusDays(record.getRentDays());
		long delayDays = ChronoUnit.DAYS.between(expectedReturnDate, record.getReturnDate());
		double fineCost = delayDays * (100+finePercent) / 100.0 * model.getPriceDay();
		fineCost = fineCost > 0 ? fineCost : 0;
		record.setCost(cost+gasCost+fineCost);
	}

	private Car carSettings(String regNumber, int damages) {
		Car car = cars.get(regNumber);
		car.setInUse(false);
		if(damages > 0 && damages <= 10) {
			car.setState(State.GOOD);
		}
		if(damages > 10) {
			car.setState(State.BAD);
		}
		if(damages > 30) {
			car.setFlRemoved(true);
		}
		return car;
	}
	
	private RentRecord getRentRecord(String regNumber, long licenseId) {
		List<RentRecord> records = carRecords.get(regNumber);
		return records == null ? null :
			records.stream()
			.filter(r -> r.getReturnDate() == null &&
			r.getLicenseId() == licenseId)
			.findFirst()
			.orElse(null);
	}

	private CarsReturnCode checkReturnCar(String carNumber, long licenseId, LocalDate returnDate, RentRecord rentRecord) {
		if(drivers.get(licenseId) == null) {
			return CarsReturnCode.NO_DRIVER;
		}
		if(rentRecord == null) {
			return CarsReturnCode.CAR_NOT_RENTED;
		}
		if(returnDate.isBefore(rentRecord.getRentDate())) {
			return CarsReturnCode.RETURN_DATE_WRONG;
		}
		return CarsReturnCode.OK;
	}

	@Override
	public CarsReturnCode removeCar(String regNumber) {
		Car car = cars.get(regNumber);
		if (car == null) {
			return CarsReturnCode.CAR_NOT_EXISTS;
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
				.collect(Collectors.toSet());
		List<Car> res = cars.entrySet().stream()
				.filter(e -> victims.contains(e.getKey()))
				.map(e -> e.getValue())
				.collect(Collectors.toList());
		victims.forEach(vn -> {
			cars.remove(vn);
			carRecords.remove(vn);
			driverRecords.values().stream()
				.forEach(lr -> lr.removeIf(r -> r.getRegNumber().equals(vn)));
			returnedRecords.values().stream()
				.forEach(lr -> lr.removeIf(r -> r.getRegNumber().equals(vn)));
		});
		return res;
	}

	@Override
	public List<Driver> getCarDrivers(String regNumber) {
		return carRecords.containsKey(regNumber) ?
				carRecords.get(regNumber).stream()
				.map(r -> r.getLicenseId())
				.map(l -> drivers.get(l))
				.distinct()
				.collect(Collectors.toList())
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
				: null;
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
		Map<String, Long> modelFrequency = getAllRecord()
				.map(r -> cars.get(r.getRegNumber()).getModelName())
				.collect(Collectors.groupingBy(n -> n, Collectors.counting()));
		long max = modelFrequency.values()
				.stream()
				.max(Long::compare)
				.orElse(0l);
		return modelFrequency.entrySet().stream()
				.filter(e -> e.getValue() == max)
				.map(e -> e.getKey())
				.collect(Collectors.toList());
	}

	@Override
	public double getModelProfit(String modelName) {
		return getAllRecord()
				.filter(r -> cars.get(r.getRegNumber()).getModelName().equals(modelName))
				.mapToDouble(r -> r.getCost())
				.sum();
	}

	@Override
	public List<String> getMostProfitModelNames() {
		Map<String, Double> modelsProfit = getAllRecord()
				.collect(Collectors.groupingBy(r -> cars.get(r.getRegNumber()).getModelName(), Collectors.summingDouble(r -> r.getCost())));
		double max = modelsProfit.values()
				.stream()
				.max(Double::compare)
				.orElse(0.0);
		return modelsProfit.entrySet().stream()
				.filter(e -> e.getValue() == max)
				.map(e -> e.getKey())
				.collect(Collectors.toList());
	}

}
