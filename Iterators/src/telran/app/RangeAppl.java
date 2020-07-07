package telran.app;

import java.util.Iterator;

import telran.iterators.RangeIterator;
//import telran.iterators.RangeIterator;
import telran.iterators.RangeReverseIterator;
import telran.range.Range;

public class RangeAppl {

	public static void main(String[] args) {

		Range range = new Range(-3, 19);
		RangeReverseIterator revIter = new RangeReverseIterator(range);
		RangeIterator iter = new RangeIterator(range);
		
//		while (iter.hasNext()) {
//			System.out.print(iter.next() + " ");
//		}
//		System.out.println();
//		
//		
//		while (revIter.hasNext()) {
//			System.out.print(revIter.next() + " ");
//		}
//		System.out.println();
		
		
		printRange(range, revIter);
		
		
		System.out.println();
		
		printRange(range);
		
		//итераторы нужно создавать заново из за каретки
		
//		for (Integer i:range)
//		{
//			System.out.print(i + " ");
//		}
//		
		
		
	
		
//		ClassWork==============================================
//		RangeIterator iterator = new RangeIterator(range);
//		while (iterator.hasNext())
//		{
//			System.out.print(iterator.next() + " ");
//		}
//		System.out.println();

			
	}

	private static void printRange(Range range) {
		for (Integer integer : range) {
			System.out.print(integer + " ");
		}
		
	}

	
	
	
	
	private static void printRange(Range range, Iterator<Integer> iter) {
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		
	}

}
