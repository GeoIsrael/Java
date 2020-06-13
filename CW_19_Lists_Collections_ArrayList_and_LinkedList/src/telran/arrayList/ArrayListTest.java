package telran.arrayList;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ArrayListTest {
	Integer[] numbers = {1,2,3,4,10,4,1,20};
	List<Integer> list;                 //переменная типа интерфейс, ее можно сделать или 
                                        //new ArrayList   или  new LinkedList    для универсальности
	@Before
	public void setUp() throws Exception {
	 list = new ArrayList<>(Arrays.asList(numbers));          //так как коллекции работают с коллекциями, нельзя принять 
	 															//массив, то существует метод .asList для массивов
	 
	 //	list = Arrays.asList(numbers);          //метод у Arrays.asList возвращает порезанный функционально LIST            
	//	list.add(5);                           //ограниченной длины, к которому нельзя добавлять элементы
	}

	@Test
	public void removeNumberTest() {
		list.remove((Integer)2);              //приведение к Integer нужно чтобы метод не принял объект как индекс
		assertFalse(list.contains(2));
		list.remove(1);
		assertFalse(list.contains(3));
		list.remove((Integer)4);              //удаляет только первый встреченный элемент
		assertTrue(list.contains(4));
	}
	
	@Test
	public void removeAllTest() {
		list.removeAll(Arrays.asList(4,1));     //метод удаления принимает коллекции, что удалять
		assertEquals(numbers.length-4, list.size());
		assertFalse(list.contains(4)&&list.contains(1));
	}
	
	@Test
	public void retainAllTest()                      //retain оставляет элементы которые передаются, остальные удаляет
	{
		list.retainAll(Arrays.asList(4,1));
		assertEquals(4, list.size());
		assertTrue(list.contains(4)&&list.contains(1));
	}
	
	@Test
	public void subListTest()                  // 
	{
		List<Integer> tmp = list.subList(0, 3);   //возвращает вью коллекции в диапазоне from(inc) - to(exc)
		tmp.remove(2);                            //все операции с вью отражаются на list !!!!
		assertFalse(list.contains(3));   
		tmp.add(100);                             // пример использования
		for(int number:list)
			System.out.print(number+" ");
	}
	                                              //сделать new List, чтобы убрать зависимость
}
