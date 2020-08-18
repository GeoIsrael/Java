
import static org.junit.Assert.*;

import java.util.function.Predicate;

import org.junit.Before;
import org.junit.Test;

public class StringsProcessingTests {
	String expectedLength5[] = {"aaaaAa","bbb  bbb","eee eeee"};
	String expectedSpaces[] = {"bbb  bbb","eee eeee"};
	String expectedCapital[] = {"CC"};
	String expectedLower[] = {"bbb  bbb","dddd","eee eeee"};
	String expectedStr[] = {"aaaaAa", "bbb  bbb", "CC", "dddd", "eee eeee"};
	StringsProcessing str;
	
	@Before
	public void setUp() throws Exception {
		str = new StringsProcessing(new String[]{"aaaaAa", "bbb  bbb", "CC", "dddd", "eee eeee"});
	}

	@Test
	public void stringsLength5() {
		//TODO test for testing StringsProcessing class
		//iterating only strings with length great than 5
		Predicate<String> predicate=new Predicate<String>() {
			public boolean test(String t) {
				return t.length()>5;
			}
		};
		testRun(predicate,expectedLength5);
	}
	@Test
	public void stringsSpaces() {
		// test for testing StringsProcessing class
		//iterating only strings containing at least one space
		Predicate<String> predicate=new Predicate<String>() {
			public boolean test(String t) {
				return t.contains(" ");
			}
		};
		testRun(predicate,expectedSpaces);
	}
	@Test
	public void stringsCapital() {
		//test for testing StringsProcessing class
		//iterating only strings with just capital letters
		Predicate<String> predicate=new Predicate<String>() {
			public boolean test(String t) {
				return t.equals(t.toUpperCase())&&!t.equals("");
			}
		};
		testRun(predicate,expectedCapital);
	}
	@Test
	public void stringsLowerCase() {
		// test for testing StringsProcessing class
		//iterating only strings with just lower case letters
		Predicate<String> predicate=new Predicate<String>() {
			public boolean test(String t) {
				return t.equals(t.toLowerCase())&&!t.equals("");
			}
		};
		testRun(predicate,expectedLower);
	}
	@Test
	public void stringsAll() {
		// test for testing StringsProcessing class
		//iterating all strings
		testRun(null,expectedStr);
	}

	private void testRun(Predicate<String> predicate, String[]expected) {
		str.setPredicate(predicate);
		int ind=0;
		for(String string:str)
			assertEquals(expected[ind++],string);
		assertEquals(expected.length,ind);
		
	}

}
