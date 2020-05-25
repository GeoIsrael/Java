package telran.nested;


public class RangeTest {

	public static void main(String[] args) {

		Range range = new Range(0, 20);
//		Iterator<Integer> iterator = new Range.RangeIteratorStatic(range);
		for (Integer integer : range) {
			System.out.print(integer + " ");
		}
		
		
	}

}
