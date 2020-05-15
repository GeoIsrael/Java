package telran.app;

import telran.impl.MyArray;

import telran.interfaces.IMyArray;

public class AppMyArray {

	public static void main(String[] args) {

//		IMyArray numbers;
		IMyArray strings;
//		Integer[] arNumbers = {10,7,11,-2,13,10};
		String[] arStrings = {"abc","lmn","fg","abc","rrrrrrrrr"};
		for (int i = 0; i < arStrings.length; i++) {
			System.out.print(arStrings[i]+" ");
		}
		strings = new MyArray();
		for(int i=0;i<arStrings.length;i++) strings.add(arStrings[i]);
		System.out.println("\n" + strings.size());
		System.out.println(strings.contains("abc"));
		System.out.println(strings.get(4));

		System.out.println(strings.remove(0));
	}
	 

}
