import java.util.Arrays;

public class NoPredicatesTestAppl {

	public static void main(String[] args) {

		int[] ar = {1,2,3,4,5,6,7,8,9,10};
		int[] oddNumbers = getOddNumbers(ar);
		int[] evenNumbers = getEvenNumbers(ar);
		int[] threeNumbers = getDivider3Numbers(ar);
		
		displayNumbers("Odd", oddNumbers);
		displayNumbers("Even", evenNumbers);
		displayNumbers("ThreeDivider", threeNumbers);
		
		
		
	}

	private static int[] getDivider3Numbers(int[] ar) {
		int count = countDivider3Number(ar);
		int[] res = new int[count];
		if (count > 0) {
			int iRes = 0;
			for (int num : ar) {
				if (num % 3 == 0) res[iRes++] = num;		
			}
		}
		return res;
	}
	

	private static int countDivider3Number(int[] ar) {
		int count = 0;
		for (int num:ar) {
			if (num % 3 == 0) count++;
		}
		return count;
	}

	
	//====================================================================
	private static int[] getEvenNumbers(int[] ar) {
		int count = countEven3Number(ar);
		int[] res = new int[count];
		if (count > 0) {
			int iRes = 0;
			for (int num : ar) {
				if (num % 2 == 0) res[iRes++] = num;		
			}
		}
		return res;	
	}

	
	private static int countEven3Number(int[] ar) {
		int count = 0;
		for (int num:ar) {
			if (num % 2 == 0) count++;
		}
		return count;
	}

	//=====================================================================
	private static int[] getOddNumbers(int[] ar) {
		int count = countOddNumber(ar);
		int[] res = new int[count];
		if (count > 0) {
			int iRes = 0;
			for (int num : ar) {
				if (num % 2 != 0) res[iRes++] = num;		
			}
		}
		return res;
	}

	
	
	private static int countOddNumber(int[] ar) {
		int count = 0;
		for (int num:ar) {
			if (num%2 != 0) count++;
		}
		return count;
	}

	
	
	private static void displayNumbers(String title, int[] arr) {
		System.out.println(title);
		System.out.println(Arrays.toString(arr));
		System.out.println("+++++++++++++++++++++++++++++++++++++");

	}

}
