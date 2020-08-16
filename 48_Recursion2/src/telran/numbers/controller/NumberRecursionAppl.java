package telran.numbers.controller;

public class NumberRecursionAppl {

	public static void main(String[] args) {
		int start = 1;
		print100Numbers(start);

	}

	private static void print100Numbers(int i) {
		try {
			int x = 1 / (100 - i);
			System.out.println(i++);
			print100Numbers(i);
		} catch (Exception e) {
			System.out.println(i);
		}

	}

}
