package rent.cars.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import rent.cars.domain.Car;
import rent.cars.domain.Driver;
import rent.cars.domain.Model;
import rent.cars.domain.RentRecord;
import rent.cars.dto.CarsReturnCode;

public interface IRentCompany {

	CarsReturnCode addModel(Model model);         //добавление модели в компанию
	
	CarsReturnCode addCar(Car car);              //добавление автомобиля 
	
	CarsReturnCode addDriver(Driver drive);     // добавление водителя
	
	Model getModel(String modelName);           //получение объекта Model по названию модели
	
	Car getCar(String regNumber);               //получить по номеру машины объект Car
	
	Driver getDriver(long licenseID);           //получить объект Driver по номеру лицензии
	
	CarsReturnCode rentCar(String regNumber, long licenseID, LocalDate returnDate, int rentDays);
	
	CarsReturnCode returnCar(String regNumber, long licenseID, LocalDate returnDate, int gasTankPercent, int damages);
	
	CarsReturnCode removeCar(String regNumber);
	
	List<Car> clear (LocalDate currentDate, int days);
	
	List<Driver> getCarDrivers(String regNumber);
	
	List<Car> getDriverCars(long licenseID);
	
	Stream<Car> getAllCars();
	
	Stream<Driver> getAllDrivers();
	
	Stream<RentRecord> getAllRecord();
	
	List<String> getMostPopularModelNames();
	
	double getModelProfit(String modelName);
	
	List<String>  getMostProfitModelNames();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
