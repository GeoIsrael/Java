package telran.linkList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import telran.list.MyLinkedList;
import telran.list.interfaces.IList;

public class LinkedListTest {
	IList<Integer> numbers;
	Integer[] num = {1,2,3,4,10,4,1,20};
	
	@Before
	public void setUp() throws Exception {
		numbers = new MyLinkedList<Integer>();
		for(int i=0; i<num.length; i++)
			numbers.add(num[i]);
	}

	@Test
	public void testSetUp() {
		int numbersSize = numbers.size();
		assertEquals(num.length, numbersSize);
		for(int i=0; i<numbersSize; i++)
		{
			assertEquals(num[i], numbers.get(i));
		}
		
	}
	
	@Test
	public void testIndexOf() {
		assertEquals(3, numbers.indexOf(4));
		assertEquals(0, numbers.indexOf(1));
		assertEquals(-1, numbers.indexOf(100));
		assertEquals(-1, numbers.indexOf(null));
		assertTrue(numbers.add(null));
		assertEquals(8, numbers.indexOf(null));
	}

	@Test
	public void testLastIndexOf() {
		assertEquals(6, numbers.lastIndexOf(1));
		assertEquals(5, numbers.lastIndexOf(4));
		assertEquals(7, numbers.lastIndexOf(20));
		assertEquals(-1, numbers.lastIndexOf(1000));
		assertTrue(numbers.add(null));
		assertEquals(8, numbers.lastIndexOf(null));
		
	}
	
	@Test
	public void testGet() {
		assertEquals((Integer)1, numbers.get(0));
		try {
		assertNotNull(numbers.get(-1));
		fail();
		}catch (IndexOutOfBoundsException e) {
		
		}
		assertEquals((Integer)4, numbers.get(3));
	}
	
	@Test
	public void testSet() {
		assertEquals(8, numbers.size());
		assertEquals((Integer)2, numbers.set(1, 200));
		assertEquals(8, numbers.size());
		assertEquals((Integer)200, numbers.get(1));
		try {
			assertNotNull(numbers.set(-1, 1000));
			fail();
		} catch (Exception e) {
			
		}
		try {
			assertNotNull(numbers.set(8, 1000));
			fail();
		} catch (Exception e) {
			
		}
		assertEquals(8, numbers.size());
	}
	
	@Test
	public void testAdd() {
		assertTrue(numbers.add(1000));
		assertEquals((Integer)1000, numbers.get(8));
	}
	
	@Test
	public void testAddByIndex() {
		Integer[] expected = {100,1,2,200,3,4,10,4,1,20};
		int i=0;
		assertEquals(8, numbers.size());
		assertTrue(numbers.add(0, 100));
		assertEquals((Integer)100, numbers.get(0));
		assertEquals(9, numbers.size());
		assertTrue(numbers.add(3, 200));
		for(Integer n:numbers)
		{
			assertEquals(expected[i++], n);
		}
		try {
			assertFalse(numbers.add(-1, 500));
			fail();
		} catch (Exception e) {
			
		}
		assertEquals(10, numbers.size());
		try {
			assertFalse(numbers.add(11, 1000));
			fail();
		} catch (Exception e) {
			
		}
		assertEquals(10, numbers.size());
		assertTrue(numbers.add(10, null));
	}
	
	@Test
	public void testRemove() {
		Integer[] expected = {1,2,3,10,4,1,20};
		assertEquals(8, numbers.size());
		assertTrue(numbers.remove((Integer)4));
		
		assertEquals(7, numbers.size());
		for(int i=0;i<numbers.size();i++)
			assertEquals(expected[i], numbers.get(i));
		assertFalse(numbers.remove((Integer)(-10)));
		assertEquals(7, numbers.size());
	}
	
	@Test
	public void testClear() {
		assertEquals(8, numbers.size());
		numbers.clear();
		assertEquals(0, numbers.size());
	}
	
	@Test
	public void testIsEmpty() {
		assertFalse(numbers.isEmpty());
		numbers.clear();
		assertTrue(numbers.isEmpty());
	}
	
	@Test
	public void testContains() {
		assertTrue(numbers.contains(4));
		assertFalse(numbers.contains(1000));
	}
}
