package telran.numbers.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import telran.numbers.*;

public class NumbersBoxTest {
int allNumbers[]= {1,2,3,4,5,6,7,8,9,10};            //входные массивы
int noDividedBy3[]= {1,2,4,5,7,8,10};
int noInRange8_11[]= {1,2,3,4,5,6,7};

INumbersBox numbersBox;
	@Before
	public void setUp() throws Exception {
//		numbersBox=new NumbersBoxArrayList();
//		numbersBox=new NumbersBoxLinkedList();
//		numbersBox=new NumbersBoxHashSet();
		numbersBox=new NumbersBoxTreeSet();                  //добавляем элементы исходного массива
		for(int number:allNumbers) {
			numbersBox.addNumber(number);
		}
	}
	
	@Test
	public void addContainsSizeTest() {                      //Проверка. метод принимает массив 
		runTest(allNumbers);                                // вызов метода runTest
	}
	
	@Test
	public void removeDividedByTest() {                      //тест удаления числа, делящегося на 3
		numbersBox.removeDividedBy(3);                        //удаляем их
		runTest(noDividedBy3);                                //проверяем другой заготовкой
	}
	@Test
	public void removeInRangeTest() {                         //--
		numbersBox.removeInRange(8, 11);
		runTest(noInRange8_11);
	}

	@Test
	public void removeRepeatedTest() {                        //удаление повторяющихся чисел
		runTest(allNumbers);                                  //проверка перед тестом
		numbersBox.addNumber(1);                             
		numbersBox.addNumber(5);
		numbersBox.addNumber(10);
		numbersBox.removeRepeated();
		runTest(allNumbers);                                  //проверка после теста
	}

	private void runTest(int[] array) {                      //проверка по размеру (size) 
		assertEquals(array.length,numbersBox.size());
		for(int number:array)
			assertTrue(numbersBox.containsNumber(number));    //и по содержимому
		
	}

}
