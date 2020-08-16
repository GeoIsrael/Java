package telran.numbers.controller;

public class RangePrintReflRec {
	public static void main(String args[]) throws Exception {
		System.out.println(getfalse(1, 100));
	}

	public static String getfalse(Integer start, Integer stop) throws Exception {
		return start + "\n" + RangePrintReflRec.class.getMethod("get" + (start == stop), Integer.class, Integer.class)
				.invoke(RangePrintReflRec.class, start + 1, stop);
	}

	public static String gettrue(Integer start, Integer stop) {
		return "";
	}

}
