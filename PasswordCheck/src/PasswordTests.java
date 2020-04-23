import static org.junit.Assert.*;

import org.junit.Test;

public class PasswordTests {

	@Test
	/**
	 * at least 8 symbols
	 * at least one uppercase letter
	 * at least one lowercase letter
	 * at least one digit
	 * at least one symbol from the following[*,&,%,!,@]
	 */
	public void rightPassword() {
		assertTrue(Password.passwordCheck("Abc&1234"));
		assertTrue(Password.passwordCheck("12345678Aa*"));
		assertTrue(Password.passwordCheck("****%!Lm12"));
		assertTrue(Password.passwordCheck("javA67&*@"));
	}
	@Test
	public void wrongLength() {
		assertFalse(Password.passwordCheck("aB1!"));
	}
	@Test
	public void wrongUppercase() {
		assertFalse(Password.passwordCheck("abc12!!**"));
	}
	@Test
	public void wrongLowercase(){
		assertFalse(Password.passwordCheck("ABC12!!**"));
	}
	@Test
	public void wrongDigit() {
		assertFalse(Password.passwordCheck("aBcdFe***"));
	}
	@Test
	public void wrongSpecSymbol(){
		assertFalse(Password.passwordCheck("Ab1234567"));
	}
	

}