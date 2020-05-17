package telran.range;

import java.util.Iterator;

//import telran.iterators.RangeIterator;
import telran.iterators.RangeReverseIterator;

public class Range implements Iterable<Integer> {

	private int min;
	private int max;
	
	
	
	public Range(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}
	
	
	
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}



	@Override
	public Iterator<Integer> iterator() {
		
		return new RangeReverseIterator(this);
	}
	
	
	
}
