package telran.reflection.controller;

public class VarArrAppl {
	public static void main(String[] args) {
		printArgs("A", "B", 2,3,5,7);    //вызываем метод

	}
	
	private static void printArgs(String a, String b, int...nums) {  //множественные аргументы
		System.out.println(a);
		System.out.println(b);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
}
