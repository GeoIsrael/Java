package telran.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import telran.impl.MyHashSet;

public class HashSetTest {

	MyHashSet<Integer> hs;
	List<Integer> actual;

	@Before
	public void setUp() throws Exception {
		actual = 
				new ArrayList<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));
		hs = new MyHashSet<>(8);
		for (Integer x : actual) {
			hs.add(x);
		}
		
	
	}
	
	@Test
	public void testIteratorPrint() {
		for (Integer num : hs) {
			System.out.println(num);
		}
	}

	@Test
	public void testIterator() {
		int size = this.actual.size();
		int counter = 0;
		for (Integer num : hs) {
			assertTrue(actual.contains(num));
			actual.remove(num);
			if (counter >= size) {
				fail("Loop");
				return;
			}
			counter++;
		}
	}

	@Test
	public void testAdd() {
		assertFalse(hs.add(19));
		assertEquals(hs.size(), actual.size());
		assertFalse(hs.contains(0));
		assertTrue(hs.add(0));
		assertEquals(hs.size(), actual.size() + 1);
		assertTrue(hs.contains(0));
	}

	@Test
	public void testContains() {
		for (Integer num : actual) {
			boolean res = hs.contains(num);
			assertTrue(res);
		}
	}

	@Test
	public void testRemove() {
		assertFalse(hs.remove(10));
		assertEquals(hs.size(), actual.size());
		assertTrue(hs.remove(11));
		assertEquals(hs.size(), actual.size() - 1);
		assertFalse(hs.contains(11));
	}

	@Test
	public void testSize() {
		assertEquals(hs.size(), actual.size());
	}
}
