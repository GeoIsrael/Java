package telran.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

public class DateSortTest {

	Comparator<String> comp;
	
	@Test
	public void test() {

		String[] dates = {"12-03-1994", "12-05-1999", "10-10-1970", "10-10-2018"};
		
		String[] expected = {"10-10-1970", "12-03-1994",  "12-05-1999",  "10-10-2018"};
		
		comp = new DateComparator();
		
		Arrays.sort(dates, comp);
		
		assertArrayEquals(expected, dates);
	}
	
}


