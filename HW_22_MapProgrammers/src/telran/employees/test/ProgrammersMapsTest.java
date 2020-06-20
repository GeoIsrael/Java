package telran.employees.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import telran.employees.dto.Programmer;
import telran.employees.service.IProgrammers;
import telran.employees.service.ProgrammersMap;

public class ProgrammersMapsTest {
private static final String CPP = "c++";                  //Набор технологий в константах
private static final String JAVA = "java";
private static final String SQL = "SQL";
private static final String WEB = "web";
private static final String PYTHON = "python";
private static final String ANDROID = "android";
private static final int ID_NEW = 11111;
String[]tech1= {CPP,JAVA,SQL};                            //массивы технологий (для присвоения тестовым объектам)
String[]tech2= {CPP,WEB};
String[]tech3= {PYTHON,ANDROID,JAVA};
int salary1=10000;                                        //зарплаты
int salary2=5000;
int salary3=15000;
Programmer progr1=new Programmer(1, "name1", salary1, tech1);     //создается 3 программиста
Programmer progr2=new Programmer(2, "name2", salary2, tech2);
Programmer progr3=new Programmer(3, "name3", salary3, tech3);
Programmer[]programmers= {progr1,progr2,progr3};                 //создается массив из 3 программистов (чтобы их использовать для помещения в коллекцию
IProgrammers programmerService;                                  //реализация интерфейса в тесте
@Before
	public void setUp() throws Exception {                      // первоначальная инициализация
	programmerService=new ProgrammersMap();                     //programmerService - реализация интерфейса ProgremmersMap - сущность, которая хранит внутри себя программистов и позволяет обращаться к ним через методы интерфейса IProgrammers
	for(Programmer programmer:programmers) {                    //итерируем массив 
		programmerService.addProgrammer(programmer);            //и заполняем MAP
	}
	}

	@Test
	public void testAddProgrammer() {
		assertFalse(programmerService.addProgrammer(progr1));      //добавить существующего программиста
		assertTrue(programmerService.addProgrammer                 //добавить нового программиста
				(new Programmer(ID_NEW, "name",
						 2000, new String[] {JAVA})));
		assertNotNull(programmerService.getProgrammerData          //проверяю что программист добавился, должен вернуться не null
				(ID_NEW));
	}

	@Test
	public void testRemoveProgrammer() {
		assertFalse(programmerService.removeProgrammer            //попытка удалить несущесствующего программиста
				(ID_NEW));
		assertTrue(programmerService.removeProgrammer             //попытка удалить существующего программиста
				(1)); 
		assertNull(programmerService.getProgrammerData(1));       //проверяю есть ли удаленный программист
	}

	@Test
	public void testGetProgrammerData() {
		assertEquals(progr1,programmerService.getProgrammerData(1));        //сравниваю программистов
	}

	@Test
	public void testAddNewTechnology() {
		assertFalse(progr2.getTechnologies().contains(JAVA));      //содержит ли 2 программист технологию JAVA    
		programmerService.addNewTechnology                         //добавляю технологию JAVA
		(2, JAVA);
		assertTrue(progr2.getTechnologies().contains(JAVA));       //проверяю содержит ли теперь технологию?
	}

	@Test
	public void testRemoveTechnology() {                      
		assertTrue(progr1.getTechnologies().contains(JAVA));       
		assertTrue(programmerService.removeTechnology
		(1, JAVA));
		assertFalse(progr2.getTechnologies().contains(JAVA));       //метод contains - это метод Set
	}

	@Test
	public void testGetProgrammersWithTechnology() {
		List<Programmer>programmers=
		programmerService.getProgrammersWithTechnology(JAVA);         //создаю лист программистов с технологией Java
		assertEquals(2,programmers.size());                           //проверяю что размер листа == 2
		assertTrue(programmers.contains(progr1));                     //и что в листе содержатся 2 программиста с технологией JAVA
		assertTrue(programmers.contains(progr3));
	}

	@Test
	public void testGetProgrammersWithSalaries() {
		List<Programmer>programmers=
				programmerService.getProgrammersWithSalary(5000, 11000);       //создаем список по аналогии с предыдущим тестом
				assertEquals(2,programmers.size());                          //проверяем размерность 
				assertTrue(programmers.contains(progr1));                   //и содержание
				assertTrue(programmers.contains(progr2));
	}

	@Test
	public void testUpdateSalary() {
		Programmer programmer=programmerService.getProgrammerData(2);       //получаем программиста у которого ID = 2
		assertEquals(salary2,programmer.getSalary());                //проверяем у него совпадение на зарплату с исходными данными зарплаты
		programmerService.updateSalary(2, salary3);                   //меняем зарплату 
		programmer=programmerService.getProgrammerData(2);           //обновляем данные по программисту 2
		assertEquals(salary3,programmer.getSalary());               //сравниваем обновленные данные
		
	}

}
