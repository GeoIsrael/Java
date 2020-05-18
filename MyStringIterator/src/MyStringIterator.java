import java.util.Iterator;

public class MyStringIterator implements Iterator<Character> {
	private StringBuilder str;
	private int curPos;
	private int size;
	
		public MyStringIterator(StringBuilder str) {
		
		this.str = str;
		curPos=0;
		size=str.length();
	}

	@Override
	public boolean hasNext() {
		
		return curPos<size;
	}

	@Override
	public Character next() {
		return str.charAt(curPos++);
//		Character current = str.charAt(curPos);
//		curPos++;
//		return current;		
	}
	
	@Override
	public void remove()
	{
		str.deleteCharAt(--curPos);
		size--;
	}

}
