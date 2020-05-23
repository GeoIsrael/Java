package telran.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Predicate;

import org.junit.Before;
import org.junit.Test;

import telran.comparators.OddEvenComparator;
import telran.comparators.SimpleNumberComparator;
import telran.comparators.StringLengthsComparator;
import telran.impl.MyArray;
import telran.interfaces.IMyArray;

public class MyArrayTest {
	IMyArray<Integer> numbers;
	IMyArray<String> strings;
	Integer[] arNumbers = {10,7,11,-2,13,10};
	String[] arStrings = {"abc","lmn","fg","abc"};
	//================================
	MyArray<Integer> otherEven;
	Integer[]arEvenNumbers= {10,-2,10};
	Integer[]arOddNumbers= {7,11,13};

	@Before
	public void setUp() throws Exception {
		numbers=new MyArray<>();
		for(int i=0;i<arNumbers.length;i++)	numbers.add(arNumbers[i]);
		
		strings = new MyArray<>();
		for(int i=0;i<arStrings.length;i++) strings.add(arStrings[i]);
		
		otherEven=new MyArray<>();
		for(int i=0;i<arEvenNumbers.length;i++)
			otherEven.add(arEvenNumbers[i]);
	}

	@Test
	public void setUpTest() {
		int sizeNumbers = numbers.size();
		int sizeStrings = strings.size();
		assertEquals(arNumbers.length, sizeNumbers);
		assertEquals(arStrings.length, sizeStrings);
		for(int i=0;i<sizeNumbers;i++)
		{
			assertEquals(arNumbers[i], numbers.get(i));
		}
		for(int i=0;i<sizeStrings;i++)
		{
			assertEquals(arStrings[i], strings.get(i));
		}
	}
	
	@Test
	public void indexOfTest()
	{
		assertEquals(0, numbers.indexOf(10));
		assertEquals(-1, numbers.indexOf(1000));
		String abc = new String("abc");
		assertEquals(0, strings.indexOf(abc));
		assertEquals(-1, strings.indexOf("kuku"));
	}
	//==============================================
	@Test
	public void addAtIndex() {
		Integer[]arNumbers5= {
				10,7,11,5,-2,13,10,2000
		};
		assertTrue(numbers.add(3,5));
		int sizeNumbers=numbers.size();
		for(int i=0;i<sizeNumbers;i++) {
			assertEquals(arNumbers5[i],numbers.get(i));
		}
		assertFalse(numbers.add(numbers.size()+1,100));
	}
	
	@Test
	public void lastIndexOf() {
		assertEquals(5,numbers.lastIndexOf(10));
		assertEquals(-1,numbers.lastIndexOf(1000));
		assertEquals(3,strings.lastIndexOf("abc"));
		assertEquals(-1,strings.lastIndexOf("kuku"));
		
	}
	@Test
	public void equals() {
		Integer a=1000;
		Integer b=1000;
		assertTrue(a.equals(b));
		String str1="Hello";
		String str2=new String("Hello");
		assertTrue(str1.equals(str2));
	}

@Test
	public void removeTest() 
	{
		//{10,7,11,-2,13,10}
		Integer[]expectedNumbersArray = {7,11,-2,13,10};
		Integer objectToBeRemovedNumber = new Integer(10);
		assertTrue(numbers.remove(objectToBeRemovedNumber));
		assertFalse(numbers.remove((Integer)100500));
		int sizeNumbers=numbers.size();
		assertEquals(expectedNumbersArray.length, sizeNumbers);
		for(int i=0;i<sizeNumbers;i++) 
		{
			assertEquals(expectedNumbersArray[i],numbers.get(i));
		}
		
		//"abc","lmn","fg","abc"
		String[]expectedStringsArray = {"lmn","fg","abc"};
		String objectToBeRemovedString = new String("abc");
		assertTrue(strings.remove(objectToBeRemovedString));
		assertFalse(strings.remove("mumu"));
		int sizeStrings=strings.size();
		assertEquals(expectedStringsArray.length, sizeStrings);
		for(int i=0;i<sizeStrings;i++) 
		{
			assertEquals(expectedStringsArray[i],strings.get(i));
		}	
	}
	@Test
	public void containsTest()
	{
		Integer target1 = new Integer(7);
		Integer target2 = new Integer(22);
		assertTrue(numbers.contains(target1));
		assertFalse(numbers.contains(target2));
		
		
		String target3 = new String("lmn");
		String target4 = new String("zaza");
		assertTrue(strings.contains(target3));
		assertFalse(strings.contains(target4));
	}
	@Test
	public void toArrayTest()
	{
		Object[] receivedArrayNumbers = numbers.toArray();
		assertArrayEquals(arNumbers, receivedArrayNumbers);
		
		Object[] receivedArrayStrings = strings.toArray();
		assertArrayEquals(arStrings, receivedArrayStrings);
	}

	@Test
	public void removeAllTest()
	{
		MyArray<Integer> expNumbers = new MyArray<>();
		expNumbers.add(10);
		expNumbers.add(-2);
		numbers.removeAll(expNumbers);
		Integer[] expArray = {7,11,13};
		assertArrayEquals(expArray, numbers.toArray());
		
	}
	
	@Test
	public void removeAtIndex() {
		Integer[]arNumbersNo_2= {
				10,7,11,13,10
		};
		assertEquals(null,numbers.remove(60));
//		int sizeNumbers=numbers.size();
//		for(int i=0;i<sizeNumbers;i++) {
//			assertEquals(arNumbersNo_2[i],numbers.get(i));
//		}
		Integer actualVal = -2;
		assertEquals(actualVal,numbers.remove(3));
		Integer[]actual=new Integer[numbers.size()];
		for(int i=0;i<actual.length;i++) {
			actual[i]=(Integer) numbers.get(i);
		}
		assertArrayEquals(arNumbersNo_2,actual);
		
	}
	@Test
	public void retainAllTest() {
		assertTrue(numbers.retainAll(otherEven));
		assertArrayEquals(arEvenNumbers,
				numbers.toArray());
		assertFalse(numbers.retainAll(otherEven));
		
	}
	@Test
	public void setTest() {
		assertNull(numbers.set(30, 1111));
		assertEquals((Integer)10, numbers.set(0, 22));
		assertEquals((Integer)22, numbers.get(0));
		
	}
	@Test
	public void clearTest() 
	{
		numbers.clear();
		assertEquals(0, numbers.size());
		strings.clear();
		assertEquals(0, strings.size());
		//=======================
		
	}
	
	@Test
	public void iteratorTest() {
		int i = 0;
		for (Integer res:numbers) {
			assertEquals(arNumbers[i++], res);
		}
		i = 0;
		for (String res: strings) {
			assertEquals(arStrings[i++], res);
		}
		
		
		Iterator<Integer> iter = numbers.iterator();
		i=0;
		while (iter.hasNext())
		{
			assertEquals(arNumbers[i++], iter.next());
		}	
	}
	
	
//	{"abc","lmn","fg","abc"};

	@Test
	public void StringsLengthTest() {
		String[] expected = {"fg","abc","lmn","abc"};
		StringLengthsComparator comp = new StringLengthsComparator();
		strings.sort(comp);
        assertArrayEquals(expected, strings.toArray());
	}
	

	
	@Test
	public void sortTest() {
		Integer[] expected = {-2,7,10,10,11,13};
		SimpleNumberComparator comp = new SimpleNumberComparator();
		numbers.sort(comp);
		assertArrayEquals(expected, numbers.toArray());
	}
	
	
//	10,7,11,-2,13,10
	@Test
	public void testOddEvenComparator() {
		Integer[] expected = {-2,10,10,13,11,7};
		OddEvenComparator comp = new OddEvenComparator();
		numbers.sort(comp);
		assertArrayEquals(expected, numbers.toArray());	
	}
	
	
	//условие для удаления - элемент меньше нуля         исходный массив: 10,7,11,-2,13,10
	@Test
	public void testRemoveByPredicate() {
		Integer[] expected = {10,7,11,13,10};
		numbers.removeIf(new Predicate<Integer>() {
			
			@Override
			public boolean test(Integer t) {
				return t<0;
			}
		});
		
		assertArrayEquals(expected, numbers.toArray());
		
		
		
	} 
	
	
	
}
