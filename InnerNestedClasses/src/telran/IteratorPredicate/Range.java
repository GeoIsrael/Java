package telran.IteratorPredicate;

import java.util.Iterator;
import java.util.function.Predicate;


public class Range implements Iterable<Integer>{

		private int min;
		private int max;
		
//------------------------
		Predicate<Integer> predicate;
		public void setPredicate(Predicate<Integer> predicate) {
			this.predicate = predicate;
		}
		
//------------------------
		
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
			
			return new RangeIterator();
		}
		
		private class RangeIterator implements Iterator<Integer> {
			
			int position = getNext(min);

			@Override
			public boolean hasNext() {
				return position <= max;
			}
			

			private int getNext(int number) {
				if(predicate == null) return number;
				while (number <= max && !predicate.test(number)) number++;
				return number;
			}


			@Override
			public Integer next() {
				int res = position;
				position = getNext(++position);
				return res;
			}
			
		}

	

	
		
		
		
}
