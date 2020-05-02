package telran.hw.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {
	
	@Test
	public void MyTest()
	{
		assertEquals((Integer)9, Calculator.computeExpressions("   1    +   1   + 7"));
		assertEquals((Integer)300, Calculator.computeExpressions("   10 + 10 - 5 / 5  *100 "));
	}
	
	@Test
	public void testWrongExpressions() {
		assertNull(Calculator.computeExpressions("25+100/"));
		assertNull(Calculator.computeExpressions("&25+100"));
		assertNull(Calculator.computeExpressions("25 100"));
		assertNull(Calculator.computeExpressions("25?100/"));
	}
	
	@Test
	public void testRightExpressions()
	{
		assertEquals((Integer)10, Calculator.computeExpressions(" 10 +10-10"));
		assertEquals((Integer)10, Calculator.computeExpressions(" 10 *10/10"));
		assertEquals((Integer)10, Calculator.computeExpressions(" 10 *10/10+10 - 10"));
		assertEquals((Integer)10, Calculator.computeExpressions("10*10/10+10-10"));
	}

}
