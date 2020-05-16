package telran.complexity;

import java.util.Arrays;

public class Complexity {

	public static void main(String[] args) {

		int [] arr = {1,2,3,4,5,3,2,5,2,3};
		
		//O(1)
		double res = arr[0]+arr[arr.length-1]/2.0;   //алгебаические функции - сложность 1
		
		//0(logN)
		int index = Arrays.binarySearch(arr, 3);     //бинарный поиск
		
		//O(N)                                       //сложнсть N - это один цикл
		for (int i = 0; i < arr.length; i++) {
			arr[i] += 1;
		}
		
		//0(N*logN)                                  //сложные сортировки у некоторых классов
		Arrays.sort(arr);
		
		//O(N^2)                                     //сортировка пузырьком (2 цикла)
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
	}

}
