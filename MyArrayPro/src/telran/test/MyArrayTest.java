package telran.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import telran.impl.MyArray;
import telran.interfaces.IMyArray;

public class MyArrayTest {
	IMyArray numbers;
	IMyArray strings;
	Integer[] arNumbers = {10,7,11,-2,13,10};
	String[] arStrings = {"abc","lmn","fg","abc"};

	@Before
	public void setUp() throws Exception {
		numbers=new MyArray();
		for(int i=0;i<arNumbers.length;i++)	numbers.add(arNumbers[i]);
		
		strings = new MyArray();
		for(int i=0;i<arStrings.length;i++) strings.add(arStrings[i]);
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
				10,7,11,5,-2,13,10
		};
		assertTrue(numbers.add(3,5));
		int sizeNumbers=numbers.size();
		for(int i=0;i<sizeNumbers;i++) {
			assertEquals(arNumbers5[i],numbers.get(i));
		}
		assertTrue(numbers.add(7,100));
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
	public void removeByIndexTest()
	{
		MyArray numbers2 = new MyArray();
		for(int i=0;i<arNumbers.length;i++)	numbers2.add(arNumbers[i]);
		assertEquals(null, numbers2.remove(9));
		assertEquals(10,numbers2.remove(0));
		assertEquals(null, numbers2.remove(-9));
	}



}
