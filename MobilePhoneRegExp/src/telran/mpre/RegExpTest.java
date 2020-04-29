package telran.mpre;

import static org.junit.Assert.*;

import org.junit.Test;

public class RegExpTest {

	@Test
	public void IsMobileTest() {
		assertTrue(MyRegExp.isMobile("0530000000"));
		assertTrue(MyRegExp.isMobile("0534567822"));
		assertTrue(MyRegExp.isMobile("+972000003344"));
		assertTrue(MyRegExp.isMobile("+972000003340"));
		
		assertFalse(MyRegExp.isMobile("05300000d"));
		assertFalse(MyRegExp.isMobile("+93200000000"));
		
	}
	
	@Test
	public void IsIpTest() {
		assertTrue(MyRegExp.isIp("10.10.10.255"));
		assertTrue(MyRegExp.isIp("8.8.8.8"));
		assertFalse(MyRegExp.isIp("10."));
		assertFalse(MyRegExp.isIp("9.4"));
		
	}

}
