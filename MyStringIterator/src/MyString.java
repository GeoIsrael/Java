import java.util.Iterator;

public class MyString implements Iterable<Character> {
	private StringBuilder str;
	
	public MyString(String string) {
		this.str=new StringBuilder(string);
	}
	
	
	public String getStr() {
		return str.toString();
	}

	public void setStr(StringBuilder str) {
		this.str = str;
	}
	
	public void addChar(char c)
	{
		str.append(c);
	}
	
	public void removeChar(char c)
	{
		int index = str.indexOf(Character.toString(c));
		str.deleteCharAt(index);
	}

	@Override
	public String toString() {
		return str.toString();
	}


	@Override
	public Iterator<Character> iterator() {
		
		return new MyStringIterator(str);
	}
	
	public int size()
	{
		return str.length();
	}

}
