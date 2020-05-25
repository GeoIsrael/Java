package telran.IteratorPredicate;

import static org.junit.Assert.*;

import java.util.function.Predicate;

import org.junit.Test;

public class RangeTest {

	int[] expected = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
	Range range = new Range(1, 20);
	
	
	@Test
	public void testAll() {
		int index = 0;
		for (int i : range) {
			assertEquals(expected[index++], i);
		}
        assertEquals(expected.length, index);
	
	}

	
	
	@Test
	public void testEven() {
		int[] expectedEven = {2,4,6,8,10,12,14,16,18,20};
		int index = 0;
		range.setPredicate(new Predicate<Integer>() {
			
			@Override
			public boolean test(Integer arg0) {
				return arg0%2==0;
			}
		});
		for (int i : range) {
			assertEquals(expectedEven[index++], i);
		}
        assertEquals(expectedEven.length, index);
		
	
	}
	
	
	@Test
	public void testOdd() {
		int[] expectedOdds = {1,3,5,7,9,11,13,15,17,19};
		int index = 0;
		range.setPredicate(new Predicate<Integer>() {
			
			@Override
			public boolean test(Integer arg0) {
				return arg0%2!=0;
			}
		});
		for (int i : range) {
			assertEquals(expectedOdds[index++], i);
		}
        assertEquals(expectedOdds.length, index);
		
		
		

	}
	
	@Test
	public void testDiv3() {
		int[] expectedDiv3 = {3,6,9,12,15,18};
		int index = 0;
		range.setPredicate(new Predicate<Integer>() {
			
			@Override
			public boolean test(Integer arg0) {
				return arg0%3==0;
			}
		});
		for (int i : range) {
			assertEquals(expectedDiv3[index++], i);
		}
        assertEquals(expectedDiv3.length, index);
		
	}

}
