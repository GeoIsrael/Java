package telran.numbers.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import telran.numbers.Calculator;

public class CalculatorTests {

	//
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testWrongExpressions() {
		assertNull(Calculator.computeExpression("25+100/"));
		assertNull(Calculator.computeExpression("&25+100"));
		assertNull(Calculator.computeExpression("25 100"));
		assertNull(Calculator.computeExpression("25?100"));
	}
	@Test
	public void testRightExpressions() {
		assertEquals((Integer)10
				,Calculator.computeExpression(" 10 +10-10"));
		assertEquals((Integer)10
				,Calculator.computeExpression(" 10 *10/10"));
		assertEquals((Integer)10
				,Calculator.computeExpression(" 10 *10/10 +10 -10 "));
		assertEquals((Integer)10
				,Calculator.computeExpression("10*10/10+10-10"));
	}

}
