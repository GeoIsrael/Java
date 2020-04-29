package telran.regexp.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import telran.regexp.StringMatcher;

public class StringMatcherTests {

	@Test
	public void testMatcherTrue() {
		assertEquals(true, StringMatcher.isTrue("true"));
		assertEquals(true, StringMatcher.isTrue("True"));
		assertEquals(false, StringMatcher.isTrue("TRue"));
		assertEquals(false, StringMatcher.isTrue("trrue"));
		assertEquals(false, StringMatcher.isTrue("truetrue"));
		assertFalse(StringMatcher.isTrue("tryue"));
	}

	
	
	@Test
	public void testMatcherNumber() {
		assertTrue(StringMatcher.isNumber("2345"));
		assertTrue(StringMatcher.isNumber("5"));
		assertFalse(StringMatcher.isNumber("2.5"));
		assertFalse(StringMatcher.isNumber("2p5"));

	}

	@Test
	public void testMatcherThreeDigitsNumber() {
		assertTrue(StringMatcher.isThreeNumber("234"));
		assertTrue(StringMatcher.isThreeNumber("235"));
		assertFalse(StringMatcher.isThreeNumber("2345"));

	}
		
	@Test
	public void testIsWord() {
		assertTrue(StringMatcher.isWord("Abd"));
		assertTrue(StringMatcher.isWord("abd"));
		assertTrue(StringMatcher.isWord("abd-abc"));
		assertFalse(StringMatcher.isWord("abdF"));
		assertFalse(StringMatcher.isWord("-abd"));
		assertFalse(StringMatcher.isWord("abd-"));
	}
	
	@Test
	public void testIsJavaName() {
		assertTrue(StringMatcher.isJavaName("AbsAbs"));
		assertTrue(StringMatcher.isJavaName("AbsAbs456"));
		assertTrue(StringMatcher.isJavaName("____"));
		
		assertFalse(StringMatcher.isJavaName("1234"));
		assertFalse(StringMatcher.isJavaName("dfg#hh"));
		assertFalse(StringMatcher.isJavaName("1hjkk"));
		assertFalse(StringMatcher.isJavaName("dfg jjh"));
	}
	
	@Test
	public void testLessThen1000() {
		assertTrue(StringMatcher.isLessThen1000("99"));
		assertTrue(StringMatcher.isLessThen1000("0"));
		assertTrue(StringMatcher.isLessThen1000("567"));
		assertFalse(StringMatcher.isLessThen1000("1000"));
		assertFalse(StringMatcher.isLessThen1000("1002"));		
	}
	
	@Test
	public void testLessThen300() {
		assertTrue(StringMatcher.isLessThen300("99"));
		assertTrue(StringMatcher.isLessThen300("299"));
		assertTrue(StringMatcher.isLessThen300("199"));
		assertFalse(StringMatcher.isLessThen300("399"));
		assertFalse(StringMatcher.isLessThen300("499"));

		
	}
	
	
}











