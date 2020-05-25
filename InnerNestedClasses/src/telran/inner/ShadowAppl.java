package telran.inner;

import telran.inner.ShadowTest.FirstLevel;

public class ShadowAppl {

	public static void main(String[] args) {
		
		ShadowTest st = new ShadowTest();
		FirstLevel fl = st.new FirstLevel();
		fl.methodInFirstLevel(500);
		
		
//		FirstLevel fl = new sh.FirstLevel();

	}

}
