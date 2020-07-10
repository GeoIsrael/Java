package telran.cars.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import telran.cars.domain.Car;
import telran.cars.domain.Driver;
import telran.cars.domain.Model;
import telran.cars.domain.RentRecord;
import telran.cars.dto.CarsReturnCode;

public interface IRentCompany {
	CarsReturnCode addModel(Model model);

	CarsReturnCode addCar(Car car);

	CarsReturnCode addDriver(Driver driver);

	Model getModel(String modelName);

	Car getCar(String regNumber);

	Driver getDriver(long licenseId);

	CarsReturnCode rentCar(String regNumber, long licenseId, 
			LocalDate rentDate, int rentDays);
	
	CarsReturnCode returnCar(String regNumber, long licenseId, 
			LocalDate returnDate, int gasTankPercent, int damages);
	
	CarsReturnCode removeCar(String regNumber);
	
	List<Car> clear(LocalDate currentDate, int days);
	
	List<Driver> getCarDrivers(String regNumber);
	
	List<Car> getDriverCars(long licenseId);
	
	Stream<Car> getAllCars();
	
	Stream<Driver> getAllDrivers();
	
	Stream<RentRecord> getAllRecord();
	
	List<String> getMostPopularModelNames();
	
	double getModelProfit(String modelName);
	
	List<String> getMostProfitModelNames();
}
