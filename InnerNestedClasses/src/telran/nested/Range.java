package telran.nested;

import java.util.Iterator;

public class Range implements Iterable<Integer>{

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
		
		return new Range.RangeIteratorStatic(this);
	}
	
	
	
	//nested class
	public static class RangeIteratorStatic implements Iterator<Integer> {

		Range range;
		private int position;
		
		public RangeIteratorStatic(Range range) {
			this.range = range;
			this.position  = range.getMin();
		}
		
		
		@Override
		public boolean hasNext() {
			return position <= range.getMax();
		}

		@Override
		public Integer next() {
			Integer res = position++;
			return res;
		}

		
		
		
	}
	
	
}
