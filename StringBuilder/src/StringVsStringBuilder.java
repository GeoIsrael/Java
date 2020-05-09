
public class StringVsStringBuilder {

	private static final int COUNT = 100_000;

	public static void main(String[] args) {

		long timestamp = System.currentTimeMillis();     //создаем текущую метку 
		concatUsingString(COUNT);
		System.out.println("String = " + (System.currentTimeMillis() - timestamp));
		
		timestamp = System.currentTimeMillis();
		concatUsingSB(COUNT);
		System.out.println("SB = " + (System.currentTimeMillis() - timestamp));
			
		
		
	}

	private static void concatUsingSB(int count2) {
		StringBuilder res = new StringBuilder();
		while (count2 >0) {
			res.append("1");
			count2--;
		}
		
	}

	private static void concatUsingString(int count2) {
		String res = new String();
		while (count2 > 0) {
			res = res + "1";
			count2 --;
		}
		
	}

}
