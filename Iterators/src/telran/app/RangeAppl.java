package telran.app;

//import telran.iterators.RangeIterator;
import telran.iterators.RangeReverseIterator;
import telran.range.Range;

public class RangeAppl {

	public static void main(String[] args) {

		Range range = new Range(-3, 19);
		RangeReverseIterator iterator = new RangeReverseIterator(range);
		for (Integer i:range)
		{
			System.out.print(i + " ");
		}
	
//		ClassWork==============================================
//		RangeIterator iterator = new RangeIterator(range);
//		while (iterator.hasNext())
//		{
//			System.out.print(iterator.next() + " ");
//		}
//		System.out.println();

			
	}

}
