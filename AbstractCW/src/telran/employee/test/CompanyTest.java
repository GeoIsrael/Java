package telran.employee.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import telran.employee.dto.Employee;
import telran.employee.dto.Manager;
import telran.employee.dto.SalesManager;
import telran.employee.dto.WageEmployee;
import telran.employee.interfaces.ICompany;
import telran.employee.model.Company;

public class CompanyTest {
	Employee john;
	Employee ann;
	Employee peter;
	Employee ivan;
	ICompany company;
	

	@Before
	public void setUp() throws Exception {
		company = new Company("Intel",5);
		john = new Manager(1000, "John", "Doe", 182, 2000, 20);
		ann = new WageEmployee(2000, "Ann", "Smith", 182, 40);
		peter = new SalesManager(3000, "Peter", "Ivanov", 182, 80000, 0.1);
		ivan = new SalesManager(4000, "Ivan", "Petrov", 91, 20000, 0.1);
		company.addEmployee(john);
		company.addEmployee(ann);
		company.addEmployee(peter);
		company.addEmployee(ivan);
		
		
	}

	@Test
	public void testAddEmployee() {
		assertFalse(company.addEmployee(ann));
		assertEquals(4, company.size());
		Employee tigran = new SalesManager(5000, "Tigran", "Petrosjan", 91, 20000, 0.1);
		assertTrue(company.addEmployee(tigran));
		assertEquals(5, company.size());
		tigran = new SalesManager(6000, "Tigran", "Petrosjan", 182, 100000, 0.1);
		assertFalse(company.addEmployee(tigran));
		assertEquals(5, company.size());	
	}

	
	@Test
	public void testRemoveEmployee() {
		assertEquals(ann, company.removeEmployee(2000));
		assertEquals(3, company.size());
		assertNull(company.removeEmployee(2000));
		assertEquals(3, company.size());
	}
	
	@Test
	public void testTotalSalary() {
		assertEquals(55470., company.totalSalary(),0.01);
	}
	
	@Test
	public void testAvgSalary() {
		assertEquals(55470./4, company.avgSalary(),0.01);
	}
	
	@Test
	public void testTotalSales() {
		assertEquals(100000, company.totalSales(), 0.01);
	}
	
	@Test
	public void testSize() {
		assertEquals(4, company.size());
	}
	
	@Test
	public void printCompany() {
		company.printCompany();
	}
	
	@Test
	public void testFindEmployeById() {
		assertEquals(john, company.findEmployeeById(1000));
		assertNull(company.findEmployeeById(5000));
	}
	
	
	
	
	
	
}
