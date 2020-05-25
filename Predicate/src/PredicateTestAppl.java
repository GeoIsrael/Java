import java.util.Arrays;
import java.util.function.Predicate;

public class PredicateTestAppl {

	public static void main(String[] args) {
		int[] ar = {1,2,3,4,5,6,7,8,9,10};
		
	//1 method without class=========================================================================	
		int[] oddNumbers = getNumbers(ar, new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				return t%2!=0;
			}
		});
		
	//2 metod with class ============================================================================
		int[] evenNumbers = getNumbers(ar, new EvenPredicate());
		
		
	//3 HW ==========================================================================================
		Predicate<Integer> predicate = new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				return t%3 == 0;
			}
		};
		
		
		int[] threeNumbers = getNumbers(ar, predicate);
		
		
		
		
		
		
		
		
		displayNumbers("Odd", oddNumbers);
		displayNumbers("Even", evenNumbers);
		displayNumbers("ThreeDivider", threeNumbers);
		
	}
	

	
	
	
	private static void displayNumbers(String title, int[] arr) {
		System.out.println(title);
		System.out.println(Arrays.toString(arr));
		System.out.println("+++++++++++++++++++++++++++++++++++++");

	}
	
	//Predicate from Java.Util.Function
	private static int count(int[] ar, Predicate<Integer> predicate)   {   		

		int count = 0;
		for (int num:ar) {
			if (predicate.test(num)) count++;
		}
		return count;
	}
	
	private static int[] getNumbers(int[] ar, Predicate<Integer> predicate) {
		int count = count(ar, predicate);
		int[] res = new int[count];
		if (count > 0) {
			int iRes = 0;
			for (int num : ar) {
				if (predicate.test(num)) res[iRes++] = num;		
			}
		}
		return res;
	}
	
}	


