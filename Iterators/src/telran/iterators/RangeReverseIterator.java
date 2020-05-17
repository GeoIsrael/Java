package telran.iterators;

import java.util.Iterator;

import telran.range.Range;

public class RangeReverseIterator implements Iterator<Integer>{
	
	private Range range;
	private int position;
	
	public RangeReverseIterator(Range range) {
		this.range = range;
		position = range.getMax();
	}
	@Override
	public boolean hasNext() {
		if (position >= range.getMin()) return true;
		return false;
	}

	@Override
	public Integer next() {
		Integer res = position;
		position --;
		return res;		
	}



}
