package telran.cars.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.cars.dao.AbstractRentCompany;
import telran.cars.dao.IRentCompany;
import telran.cars.dao.RentCompany;
import telran.cars.domain.Car;
import telran.cars.domain.Driver;
import telran.cars.domain.Model;
import telran.cars.domain.RentRecord;
import telran.cars.dto.CarsReturnCode;
import telran.cars.dto.State;
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
	private static final LocalDate RETURN_DATE_WRONG = RENT_DATE1.minusDays(1);
	private static final LocalDate RETURN_DATE = RENT_DATE1.plusDays(RENT_DAYS1);
	private static final long DELAY_DAYS = 2;
	private static final LocalDate RETURN_DATE_DELAY = RETURN_DATE.plusDays(DELAY_DAYS);
	private static final int GAS_PERCENT = 50;
	private static final int DAMAGES = 50;
	private static final LocalDate CURRENT_DATE = LocalDate.of(2020, 10, 10);
	private static final int CLEAR_DAYS = 10;
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
	void testReturnCarCodes() {
		assertEquals(CarsReturnCode.CAR_NOT_RENTED, company.returnCar(REG_NUMBER2, LICENSE1,
				RENT_DATE1, 100, 0));
		assertEquals(CarsReturnCode.NO_DRIVER, company.returnCar(REG_NUMBER1, LICENSE2,
				RENT_DATE1, 100, 0));
		company.addDriver(driver2);
		assertEquals(CarsReturnCode.CAR_NOT_RENTED, company.returnCar(REG_NUMBER1, LICENSE2,
				RENT_DATE1, 100, 0));
		assertEquals(CarsReturnCode.RETURN_DATE_WRONG, company.returnCar(REG_NUMBER1, LICENSE1,
				RETURN_DATE_WRONG, 100, 0));
		assertEquals(CarsReturnCode.OK, company.returnCar(REG_NUMBER1, LICENSE1,
				RETURN_DATE, 100, 0));
	}
	
	@Test
	void testReturnCarNoDamagesNoAdditionalCosts() {
		company.returnCar(REG_NUMBER1, LICENSE1, RETURN_DATE, 100, 0);
		assertFalse(car1.isInUse());
		assertEquals(State.EXCELLENT, car1.getState());
		assertFalse(car1.isFlRemoved());
		rentRecord.setReturnDate(RETURN_DATE);
		rentRecord.setDamages(0);
		rentRecord.setGasTankPercent(100);
		rentRecord.setCost(model1.getPriceDay() * RENT_DAYS1);
		RentRecord record1 = getRecord(REG_NUMBER1);
		assertEquals(rentRecord, record1);
		assertEquals(rentRecord.getReturnDate(), record1.getReturnDate());
		assertEquals(rentRecord.getDamages(), record1.getDamages());
		assertEquals(rentRecord.getGasTankPercent(), record1.getGasTankPercent());
		assertEquals(rentRecord.getCost(), record1.getCost(), 0.01);	
	}
	
	@Test
	void testReturnCarWithDamagesAdditionalCosts() {
		company.returnCar(REG_NUMBER1, LICENSE1, RETURN_DATE_DELAY, GAS_PERCENT, DAMAGES);
		assertFalse(car1.isInUse());
		assertTrue(car1.isFlRemoved());
		rentRecord.setReturnDate(RETURN_DATE_DELAY);
		rentRecord.setDamages(DAMAGES);
		rentRecord.setGasTankPercent(GAS_PERCENT);
		rentRecord.setCost(model1.getPriceDay() * RENT_DAYS1 + getAdditionalCost());
		RentRecord record1 = getRecord(REG_NUMBER1);
		assertEquals(rentRecord, record1);
		assertEquals(rentRecord.getReturnDate(), record1.getReturnDate());
		assertEquals(rentRecord.getDamages(), record1.getDamages());
		assertEquals(rentRecord.getGasTankPercent(), record1.getGasTankPercent());
		assertEquals(rentRecord.getCost(), record1.getCost(), 0.01);	
	}

	private double getAdditionalCost() {
		int gasPrice = ((AbstractRentCompany) company).getGasPrice();
		int finePercent = ((AbstractRentCompany) company).getFinePercent();
		int gasTank = model1.getGasTank();
		int priceDay = model1.getPriceDay();
		return (gasTank - gasTank * GAS_PERCENT / 100.) * gasPrice +
				(priceDay + priceDay * finePercent / 100.) * DELAY_DAYS;
	}

	@Test
	void testRemoveCar() {
		assertEquals(CarsReturnCode.CAR_NOT_EXISTS, company.removeCar(REG_NUMBER2));
		assertEquals(CarsReturnCode.CAR_IN_USE, company.removeCar(REG_NUMBER1));
		company.returnCar(REG_NUMBER1, LICENSE1, RETURN_DATE, 100, 0);
		assertEquals(CarsReturnCode.OK, company.removeCar(REG_NUMBER1));
		assertTrue(car1.isFlRemoved());
		assertEquals(CarsReturnCode.CAR_NOT_EXISTS, company.rentCar(REG_NUMBER1, LICENSE1, 
				RENT_DATE1.plusDays(RENT_DAYS1 * 2), RENT_DAYS1));
	}

	@Test
	void testClear() {
		setUpClear();
		//assumed car1 and car2 are deleted. car3 is not deleted
		List<Car> carsActual = company.clear(CURRENT_DATE, CLEAR_DAYS);
		Car[] carsExpected = {car1, car2};
		carsActual.sort((x,y) -> x.getRegNumber().compareTo(y.getRegNumber()));
		assertArrayEquals(carsExpected, carsActual.toArray());
		assertNull(company.getCar(REG_NUMBER1));
		assertNull(company.getCar(REG_NUMBER2));
		assertNotNull(company.getCar(REG_NUMBER3));
		company.getAllRecord()
		.forEach(r -> assertFalse(r.getRegNumber().equals(REG_NUMBER1) || r.getRegNumber().equals(REG_NUMBER2)));	
	}

	private void setUpClear() {
		company.returnCar(REG_NUMBER1, LICENSE1, RETURN_DATE, 0, 90);
		company.addModel(model2);
		company.addCar(car2);
		company.addCar(car3);
		company.rentCar(REG_NUMBER2, LICENSE1, RENT_DATE1, RENT_DAYS1);
		company.rentCar(REG_NUMBER3, LICENSE1, RENT_DATE1, RENT_DAYS1);
		company.returnCar(REG_NUMBER2, LICENSE1, RETURN_DATE, 100, 0);
		company.removeCar(REG_NUMBER2);
		company.returnCar(REG_NUMBER3, LICENSE1, RETURN_DATE, 100, 0);
		
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
		setupStatistics();
		String[] expecteds = {MODEL2, MODEL1};
		List<String> actuals = company.getMostPopularModelNames();
		actuals.sort(String::compareTo);
		assertArrayEquals(expecteds, actuals.toArray());
	}

	@Test
	void testGetModelProfit() {
		setupStatistics();
		assertEquals(model1.getPriceDay() * RENT_DAYS1 * 3, company.getModelProfit(MODEL1));
		assertEquals(model2.getPriceDay() * RENT_DAYS1 * 3, company.getModelProfit(MODEL2));
	}

	@Test
	void testGetMostProfitModelNames() {
		setupStatistics();
		String[] expecteds = {MODEL1};
		List<String> actual = company.getMostProfitModelNames();
		assertArrayEquals(expecteds, actual.toArray());
	}
	
	private void setupStatistics() {
		company.returnCar(REG_NUMBER1, LICENSE1, RETURN_DATE, 100, 0);
		rentReturn(REG_NUMBER1, 1);
		company.addModel(model2);
		company.addCar(car2);
		rentReturn(REG_NUMBER2, 3);
		company.addCar(car3);
		rentReturn(REG_NUMBER3, 1);
	}

	private void rentReturn(String regNumber, int n) {
		for(int i = 0; i < n; i++) {
			company.rentCar(regNumber, LICENSE1, RENT_DATE1, RENT_DAYS1);
			company.returnCar(regNumber, LICENSE1, RETURN_DATE, 100, 1);
		}
		
	}

}


