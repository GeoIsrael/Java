package telran.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import telran.dto.Employee;
import telran.model.Company;

public class EmployeeTest {
	private static final long ID1 = 1234, ID3=3456;
	private static final int SALARY1 = 15000;
	private static final String DEPARTMENT1 = "Development";
	private static final String TITLE1 = "Developer";
	private static final String NAME = "John Doe";
	
	Employee emp1 = new Employee(ID1, SALARY1, DEPARTMENT1, TITLE1, NAME);
	Employee emp2 = new Employee(ID1, SALARY1, DEPARTMENT1, TITLE1, NAME);
	Employee emp3 = new Employee(ID3, SALARY1, DEPARTMENT1, TITLE1, NAME);
    Company company;
	
	@Before
	public void setUp() {
		company = new Company();
		company.hire(emp1);
	}
			

	@Test
	public void testConstructor() {
		assertEquals(emp1, emp2);
		assertFalse(emp1==emp2);
	}
	
	@Test
	public void testGetters() {
		assertEquals(ID1, emp1.getId());
		assertEquals(SALARY1, emp1.getSalary());
		assertEquals(DEPARTMENT1, emp1.getDepartment());
		assertEquals(TITLE1, emp1.getTitle());
		assertEquals(NAME, emp1.getName());

	}

	//----------------------------------------------------------
	@Test
	public void testHire() {
		assertTrue(company.hire(emp3));
		assertFalse(company.hire(emp2));
		assertFalse(company.hire(emp1));

	}
	
	@Test
	public void testGetEmployee() {
		assertEquals(ID1,emp1.getId());
		assertNull(company.getEmployee(ID3));
	}
	
	
	
	
	
}




















