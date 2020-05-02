package telran.mpre;

import static org.junit.Assert.*;

import org.junit.Test;

public class RegExpTest {

	@Test
	public void Is255Test() {
		assertTrue(MyRegExp.is255("1"));
		assertTrue(MyRegExp.is255("255"));
		assertTrue(MyRegExp.is255("145"));
		assertTrue(MyRegExp.is255("76"));
		
		assertFalse(MyRegExp.is255("256"));
		assertFalse(MyRegExp.is255("566"));
		
	}
	
	@Test
	public void IsIpTest() {
		assertTrue(MyRegExp.isIpv4("255.255.255.255"));
		assertTrue(MyRegExp.isIpv4("8.8.8.8"));
		assertFalse(MyRegExp.isIpv4("10."));
		assertFalse(MyRegExp.isIpv4("9.4"));
		
	}
	
	
	@Test
	public void isIsraelMobileTest() {
		assertTrue(MyRegExp.isIsraelMobile("+972531111222"));
		assertTrue(MyRegExp.isIsraelMobile("0532123456"));
		assertFalse(MyRegExp.isIsraelMobile("10."));
		assertFalse(MyRegExp.isIsraelMobile("9.4"));
		
	}
	
	@Test
	public void isEmailTest() {
		assertTrue(MyRegExp.isEmailMailRu("123@mail.ru"));
		assertTrue(MyRegExp.isEmailMailRu("333@mail.ru"));
		assertFalse(MyRegExp.isEmailMailRu("10."));
		assertFalse(MyRegExp.isEmailMailRu("9.4"));
		
	}
	
	@Test
	public void isTimeTest() {
		assertTrue(MyRegExp.isTime("22:12"));
		assertTrue(MyRegExp.isTime("23:59"));
		assertTrue(MyRegExp.isTime("00:00"));
		assertTrue(MyRegExp.isTime("13:12"));
		
		assertFalse(MyRegExp.isTime("10:60"));
		assertFalse(MyRegExp.isTime("24:00"));
	}
	
	
	@Test
	public void isColorTest() {
		assertTrue(MyRegExp.isColor("#aaaaaa"));
		assertTrue(MyRegExp.isColor("#000000"));
		assertTrue(MyRegExp.isColor("#935432"));
		
		assertFalse(MyRegExp.isColor("#ggghhj"));
		assertFalse(MyRegExp.isColor("#fffffk"));
	}
	
	@Test
	public void isArithmeticTest() {
		assertTrue(MyRegExp.isArithmetic(" - 1 + 2"));
		assertTrue(MyRegExp.isArithmetic("5 / 5"));
		assertTrue(MyRegExp.isArithmetic("2-1"));
		
		assertFalse(MyRegExp.isArithmetic("4df"));
		assertFalse(MyRegExp.isArithmetic("5 6"));
	}
	
	

}
