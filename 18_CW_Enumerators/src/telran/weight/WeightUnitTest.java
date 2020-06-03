package telran.weight;

import static org.junit.Assert.*;

import org.junit.Test;

public class WeightUnitTest {

	@Test
	public void testConvert() {
		assertEquals(1000.0f, WeightUnit.TN.convert(WeightUnit.KG),0.01);
		assertEquals(0.001f, WeightUnit.KG.convert(WeightUnit.TN), 0.01);
	}
	
	@Test
	public void testGetGrammAmount() {
		assertEquals(453.592f, WeightUnit.LBS.getGramAmount(), 0.01);
	}

}
