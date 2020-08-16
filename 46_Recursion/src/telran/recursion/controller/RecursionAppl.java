package telran.recursion.controller;

public class RecursionAppl {

	public static void main(String[] args) {
//		int res = factorial(6);
//		System.out.println(res);
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int index = binarySearch(arr, 1);
		System.out.println(index);

	}

	public static int factorial(int n) {
		return n == 0 ? 1 : n * factorial(n - 1);
	}

	public static int binarySearch(int[] arr, int number) {
		return binarySearch(arr, number, 0, arr.length);
	}

	//divide-and-conquer approach
	private static int binarySearch(int[] arr, int number, int l, int r) {
		if (l > r) {
			return -1;
		}
		int mid = (r - l) / 2 + l;
		if (arr[mid] == number) {
			return mid;
		}
		if (arr[mid] < number) {
			return binarySearch(arr, number, mid + 1, r);
		} else {
			return binarySearch(arr, number, l, mid - 1);
		}

	}

//	public static int binarySearch(int[] arr, int number) {
//		int l = 0;
//		int r = arr.length - 1;
//		while (l <= r) {
//			int mid = (r - l) / 2 + l;
//			if (arr[mid] == number) {
//				return mid;
//			}
//			if (arr[mid] < number) {
//				l = mid + 1;
//			}
//			if (arr[mid] > number) {
//				r = mid - 1;
//			}
//		}
//		return -1;
//	}

//	public static int factorial(int n) {
//		if (n == 0) {
//			return 1;
//		}
//		int res = 1;
//		for (int i = 1; i <= n; i++) {
//			res *= i;
//		}
//		return res;
//	}

}
