
import java.util.Iterator;
import java.util.function.Predicate;

public class StringsProcessing implements Iterable<String> 
{
	String strings[];
	Predicate<String> predicate;

	public StringsProcessing(String[] strings) {
		super();
		this.strings = strings;
	}

	public void setPredicate(Predicate<String> predicate) {
		this.predicate = predicate;
	}

	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {
			int current=getNext(0);
			
			private int getNext(int index) {
				if(predicate==null)
					return index;
				while(index<strings.length&&!predicate.test(strings[index]))
					index++;
				return index;
			}
			
			@Override
			public boolean hasNext() {
				return current<strings.length;
			}

			@Override
			public String next() {
				String res=strings[current];
				current=getNext(current+1);
				return res;
			}
		};
	}
}
