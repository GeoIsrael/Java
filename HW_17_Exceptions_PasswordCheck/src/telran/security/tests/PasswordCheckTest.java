package telran.security.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import telran.security.PasswordCheck;
import telran.security.IllegalPasswordException;

public class PasswordCheckTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void rightPassword() throws IllegalPasswordException {
		PasswordCheck.check("12%AbcD7u");
		PasswordCheck.check("12*AbcD7u");
	}
	@Test
	public void wrongLength() {
		String[] expected=
			{PasswordCheck.WRONG_LENGTH_MESSAGE};
		try {
			PasswordCheck.check("12%A bc");
			fail("no exception");
		} catch (IllegalPasswordException e) {
			assertArrayEquals(expected,e.getMessages());
		}
	}
	@Test
	public void noSpecSymbol() {
		String[] expected= {PasswordCheck.NO_SPEC_SYMBOL_MESSAGE};
		try {
			PasswordCheck.check("12Abc345");
			fail("no exception");
		} catch (IllegalPasswordException e) {
			assertArrayEquals(expected,e.getMessages());
		}
	}
	@Test
	public void noDigit() {
		String[] expected= {PasswordCheck.NO_DIGIT_MESSAGE};
		try {
			PasswordCheck.check("Abc*Ut**");
			fail("no exception");
		} catch (IllegalPasswordException e) {
			assertArrayEquals(expected,e.getMessages());
		}
	}
	@Test
	public void noUpperCase() {
		String[] expected= {PasswordCheck.NO_UPPER_CASE_MESSAGE};
		try {
			PasswordCheck.check("12abc$345");
			fail("no exception");
		} catch (IllegalPasswordException e) {
			assertArrayEquals(expected,e.getMessages());
		}
	}
	@Test
	public void noLowerCase() {
		String[] expected= {PasswordCheck.NO_LOWER_CASE_MESSAGE};
		try {
			PasswordCheck.check("12ABC$345");
			fail("no exception");
		} catch (IllegalPasswordException e) {
			assertArrayEquals(expected,e.getMessages());
		}
	}
	@Test
	public void wrongSymbol() {
		String[] expected= {PasswordCheck.WRONG_SYMBOL_MESSAGE};
		try {
			PasswordCheck.check("12ABC$3 45");
			fail("no exception");
		} catch (IllegalPasswordException e) {
			assertArrayEquals(expected,e.getMessages());
		}
	}
	@Test
	public void noAllTogether() {
		String[] expected= {
				PasswordCheck.NO_LOWER_CASE_MESSAGE,
				PasswordCheck.NO_DIGIT_MESSAGE,
				PasswordCheck.NO_SPEC_SYMBOL_MESSAGE,
				};
		try {
			PasswordCheck.check("AAAAAAAAAAA");
			fail("no exception");
		} catch (IllegalPasswordException e) {
			assertArrayEquals(expected,e.getMessages());
		}
	}
	}


