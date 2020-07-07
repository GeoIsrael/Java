package telran.cars.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.cars.dao.IRentCompany;
import telran.cars.dao.RentCompany;
import telran.cars.domain.Car;
import telran.cars.domain.Driver;
import telran.cars.domain.Model;
import telran.cars.domain.RentRecord;
import telran.cars.dto.CarsReturnCode;
import telran.cars.dto.WrongArgumentException;

class RentCompanyTest {
	private static final String REG_NUMBER1 = "123";
	private static final String REG_NUMBER2 = "124";
	private static final String REG_NUMBER3 = "125";
	private static final String MODEL1 = "BMW12";
	private static final String MODEL2 = "B4";
	private static final long LICENSE1 = 123;
	private static final long LICENSE2 = 124;
	private static final LocalDate RENT_DATE1 = LocalDate.of(2020, 7, 5);
	private static final int RENT_DAYS1 = 5;
	private IRentCompany company;
	Car car1 = new Car(REG_NUMBER1, "red", MODEL1);
	Car car2 = new Car(REG_NUMBER2, "green", MODEL2);
	Car car3 = new Car(REG_NUMBER3, "silver", MODEL1);
	Model model1 = new Model(MODEL1, 55, "Germany", "BMW", 200);
	Model model2 = new Model(MODEL2, 50, "Japan", "Subaru", 190);
	Driver driver1 = new Driver(LICENSE1, "Moshe", 1980, "050-1234567");
	Driver driver2 = new Driver(LICENSE2, "David", 1960, "050-7654321");
	RentRecord rentRecord;

	@BeforeEach
	void setUp() throws Exception {
		company = new RentCompany();
		company.addModel(model1);
		company.addDriver(driver1);
		company.addCar(car1);
		company.rentCar(REG_NUMBER1, LICENSE1, RENT_DATE1, RENT_DAYS1);
		rentRecord = new RentRecord(LICENSE1, REG_NUMBER1, RENT_DATE1, RENT_DAYS1);
	}

	@Test
	void testAddModel() {
		assertThrows(WrongArgumentException.class, () -> company.addModel(null));
		boolean flagThrow = false;
		try {
			company.addModel(null);
		} catch (Exception e) {
			flagThrow = true;
		}
		assertTrue(flagThrow);
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
		assertEquals(CarsReturnCode.CAR_IN_USE, 
				company.rentCar(REG_NUMBER1, LICENSE1, RENT_DATE1, RENT_DAYS1));
		assertEquals(CarsReturnCode.CAR_NOT_EXISTS, 
				company.rentCar(REG_NUMBER2, LICENSE1, RENT_DATE1, RENT_DAYS1));
		company.addModel(model2);
		company.addCar(car2);
		assertEquals(CarsReturnCode.NO_DRIVER, 
				company.rentCar(REG_NUMBER2, LICENSE2, RENT_DATE1, RENT_DAYS1));
		assertEquals(CarsReturnCode.OK, 
				company.rentCar(REG_NUMBER2, LICENSE1, RENT_DATE1, RENT_DAYS1));
		assertTrue(car1.isInUse());
		RentRecord record1 = getRecord(REG_NUMBER1);
		assertEquals(rentRecord, record1);
		assertEquals(LICENSE1, record1.getLicenseId());
		assertEquals(RENT_DATE1, record1.getRentDate());
		assertEquals(RENT_DAYS1, record1.getRentDays());
		
	}

	private RentRecord getRecord(String regNumber1) {
		return company.getAllRecord()
				.filter(r -> r.getRegNumber().equals(regNumber1))
				.findFirst().orElse(null);
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
		company.getCarDrivers(REG_NUMBER1)
		.forEach(d -> assertEquals(driver1, d));
		assertNull(company.getCarDrivers(REG_NUMBER2));
	}

	@Test
	void testGetDriverCars() {
		company.getDriverCars(LICENSE1)
		.forEach(c -> assertEquals(car1, c));
		assertNull(company.getDriverCars(LICENSE2));
	}

	@Test
	void testGetAllCars() {
		company.addCar(car3);
		Car[] expected = {car1, car3};
		Object[] actual = company.getAllCars()
		.sorted((c1,c2) -> c1.getRegNumber().compareTo(c2.getRegNumber()))
		.toArray();
		assertArrayEquals(expected, actual);
	}

	@Test
	void testGetAllDrivers() {
		company.addDriver(driver2);
		Driver[] expected = {driver1, driver2};
		Object[] actual = company.getAllDrivers()
				.sorted((d1,d2) -> Long.compare(d1.getLicenseId(), d2.getLicenseId()))
				.toArray();
		assertArrayEquals(expected, actual);
	}

	@Test
	void testGetAllRecord() {
		company.getAllRecord()
			.forEach(r -> assertEquals(rentRecord, r));
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
