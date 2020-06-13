import static org.junit.Assert.*;

import org.junit.Test;

public class LengthTest {
	Length length1M = new Length(10.f, LengthUnit.M);
	Length lengthCM = new Length(1000.f, LengthUnit.CM);
	Length length2M = new Length(20.f, LengthUnit.M);
	

	@Test
	public void plusTest() {
		Length res1 = new Length(20.f, LengthUnit.M);
		Length res2 = new Length(2000.f, LengthUnit.CM);
		assertEquals(res1, length1M.plus(lengthCM));
		assertEquals(res2, lengthCM.plus(length1M));
		
	}
	
	@Test
	public void minusTest() {
		Length res1=new Length(0f,LengthUnit.M);
		Length res2=new Length(0f,LengthUnit.CM);
		assertEquals(res1,length1M.minus(lengthCM));
		assertEquals(res2,lengthCM.minus(length1M));
	}
	@Test
	public void toStringTest() {                                  //тест toString
		assertEquals("10M",length1M.toString());
		assertEquals("1000CM",lengthCM.toString());
	}
	@Test
	public void convertTest() {
		assertEquals(lengthCM,
				length1M.convert(LengthUnit.CM));
		assertEquals(length1M,
				lengthCM.convert(LengthUnit.M));
	}
	@Test
	public void betweenTest() {
		assertEquals(-10000.0f,
				LengthUnit.MM.between(length2M,lengthCM),0.00001f);
		assertEquals(10f,LengthUnit.M.
				between(lengthCM,length2M),0.00001f);
		assertEquals(-1000f,LengthUnit.CM.
				between(length2M,lengthCM),0.00001f);
	}

}
