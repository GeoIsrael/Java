package telran.cars.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.cars.dao.IRentCompany;
import telran.cars.dao.RentCompany;
import telran.cars.domain.Car;
import telran.cars.domain.Driver;
import telran.cars.domain.Model;
import telran.cars.dto.CarsReturnCode;

class RentCompanyTest {
	private static final String REG_NUMBER1 = "123";
	private static final String REG_NUMBER2 = "124";
	private static final String REG_NUMBER3 = "125";
	private static final String MODEL1 = "BMW12";
	private static final String MODEL2 = "B4";
	private static final long LICENSE1 = 123;
	private static final long LICENSE2 = 124;
	private IRentCompany company;
	Car car1 = new Car(REG_NUMBER1, "red", MODEL1);
	Car car2 = new Car(REG_NUMBER2, "green", MODEL2);
	Car car3 = new Car(REG_NUMBER3, "silver", MODEL1);
	Model model1 = new Model(MODEL1, 55, "Germany", "BMW", 200);
	Model model2 = new Model(MODEL2, 50, "Japan", "Subaru", 190);
	Driver driver1 = new Driver(LICENSE1, "Moshe", 1980, "050-1234567");
	Driver driver2 = new Driver(LICENSE2, "David", 1960, "050-7654321");

	@BeforeEach
	void setUp() throws Exception {
		company = new RentCompany();
		company.addModel(model1);
		company.addDriver(driver1);
		company.addCar(car1);
	}

	@Test
	void testAddModel() {
		assertEquals(CarsReturnCode.MODEL_EXISTS,
				company.addModel(model1));
		assertEquals(CarsReturnCode.OK,company.addModel(model2));
	}

	@Test
	void testAddCar() {
		assertEquals(CarsReturnCode.CAR_EXISTS,
				company.addCar(car1));
		assertEquals(CarsReturnCode.NO_MODEL,
				company.addCar(car2));
		assertEquals(CarsReturnCode.OK,
				company.addCar(car3));
	}

	@Test
	void testAddDriver() {
		assertEquals(CarsReturnCode.DRIVER_EXISTS,company.addDriver(driver1));
		assertEquals(CarsReturnCode.OK,company.addDriver(driver2));
	}

	@Test
	void testGetModel() {
		assertNull(company.getModel(MODEL2));
		assertEquals(model1,company.getModel(MODEL1));
	}

	@Test
	void testGetCar() {
		assertNull(company.getCar(REG_NUMBER2));
		assertEquals(car1,company.getCar(REG_NUMBER1));
	}

	@Test
	void testGetDriver() {
		assertNull(company.getDriver(LICENSE2));
		assertEquals(driver1,company.getDriver(LICENSE1));
	}

	@Test
	void testRentCar() {
		fail("Not yet implemented");
	}

	@Test
	void testReturnCar() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveCar() {
		fail("Not yet implemented");
	}

	@Test
	void testClear() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCarDrivers() {
		fail("Not yet implemented");
	}

	@Test
	void testGetDriverCars() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllCars() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllDrivers() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllRecord() {
		fail("Not yet implemented");
	}

	@Test
	void testGetMostPopularModelNames() {
		fail("Not yet implemented");
	}

	@Test
	void testGetModelProfit() {
		fail("Not yet implemented");
	}

	@Test
	void testGetMostProfitModelNames() {
		fail("Not yet implemented");
	}

}
