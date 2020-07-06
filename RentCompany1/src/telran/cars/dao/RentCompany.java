package telran.cars.dao;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

import telran.cars.domain.Car;
import telran.cars.domain.Driver;
import telran.cars.domain.Model;
import telran.cars.domain.RentRecord;
import telran.cars.dto.CarsReturnCode;

public class RentCompany extends AbstractRentCompany {
	private Map<String, Car> cars = new HashMap<>();
	private Map<Long, Driver> drivers = new HashMap<>(); 
	private Map<String, Model> models = new HashMap<>();
	private Map<String, List<RentRecord>> carRecords = new HashMap<>();
	private Map<Long, List<RentRecord>> driverRecords = new HashMap<>();
	private TreeMap<LocalDate, List<RentRecord>> returnedRecords = new TreeMap<>();

	@Override
	public CarsReturnCode addModel(Model model) {
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
	public CarsReturnCode rentCar(String regNumber, long licenseId, LocalDate rentDate, int rentDays) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> getDriverCars(long licenseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stream<Car> getAllCars() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stream<Driver> getAllDrivers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stream<RentRecord> getAllRecord() {
		// TODO Auto-generated method stub
		return null;
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
