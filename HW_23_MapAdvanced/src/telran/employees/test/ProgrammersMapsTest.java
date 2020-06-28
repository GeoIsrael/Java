package telran.employees.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import telran.employees.dto.Programmer;
import telran.employees.service.IProgrammers;
import telran.employees.service.ProgrammersMap;

public class ProgrammersMapsTest {
private static final String CPP = "c++";
private static final String JAVA = "java";
private static final String SQL = "SQL";
private static final String WEB = "web";
private static final String PYTHON = "python";
private static final String ANDROID = "android";
private static final int ID_NEW = 11111;
String[]tech1= {CPP,JAVA,SQL};
String[]tech2= {CPP,WEB};
String[]tech3= {PYTHON,ANDROID,JAVA};
int salary1=10000;
int salary2=5000;
int salary3=15000;
Programmer progr1=new Programmer(1, "name1", salary1, tech1);
Programmer progr2=new Programmer(2, "name2", salary2, tech2);
Programmer progr3=new Programmer(3, "name3", salary3, tech3);
Programmer[]programmers= {progr1,progr2,progr3};
IProgrammers programmerService;
@Before
	public void setUp() throws Exception {
	programmerService=new ProgrammersMap();
	for(Programmer programmer:programmers) {
		programmerService.addProgrammer(programmer);
	}
	}

	@Test
	public void testAddProgrammer() {
		assertFalse(programmerService.addProgrammer(progr1));
		assertTrue(programmerService.addProgrammer
				(new Programmer(ID_NEW, "name",
						 2000, new String[] {JAVA})));
		assertNotNull(programmerService.getProgrammerData
				(ID_NEW));
	}

	@Test
	public void testRemoveProgrammer() {
		assertFalse(programmerService.removeProgrammer
				(ID_NEW));
		assertTrue(programmerService.removeProgrammer
				(1));
		assertNull(programmerService.getProgrammerData(1));
	}

	@Test
	public void testGetProgrammerData() {
		assertEquals(progr1,programmerService.getProgrammerData(1));
	}

	@Test
	public void testAddNewTechnology() {
		assertFalse(progr2.getTechnologies().contains(JAVA));
		assertTrue(programmerService.addNewTechnology
		(2, JAVA));
		assertTrue(progr2.getTechnologies().contains(JAVA));
	}

	@Test
	public void testRemoveTechnology() {
		assertTrue(progr1.getTechnologies().contains(JAVA));
		assertTrue(programmerService.removeTechnology
		(1, JAVA));
		assertFalse(progr2.getTechnologies().contains(JAVA));
	}

	@Test
	public void testGetProgrammersWithTechnology() {
		List<Programmer>programmers=
		programmerService.getProgrammersWithTechnology(JAVA);
		assertEquals(2,programmers.size());
		assertTrue(programmers.contains(progr1));
		assertTrue(programmers.contains(progr3));
	}

	@Test
	public void testGetProgrammersWithSalaries() {
		List<Programmer>programmers=
				programmerService.getProgrammersWithSalary(5000, 11000);
				assertEquals(2,programmers.size());
				assertTrue(programmers.contains(progr1));
				assertTrue(programmers.contains(progr2));
	}

	@Test
	public void testUpdateSalary() {
		Programmer programmer=programmerService.getProgrammerData(2);
		assertEquals(salary2,programmer.getSalary());
		assertFalse(programmerService.updateSalary(2, salary2));
		assertTrue(programmerService.updateSalary(2, salary3));
		programmer=programmerService.getProgrammerData(2);
		assertEquals(salary3,programmer.getSalary());
		
	}

}
