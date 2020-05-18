import java.util.Iterator;

public class MyStringAppl {

	public static void main(String[] args) {
		MyString myStr=new MyString("Two beer, or not two beer");
		System.out.println(myStr);
		System.out.println(myStr.size());
		
//		for(Character c:myStr)
//		{
//			if(c=='e') myStr.removeChar(c);
//		}
		Iterator<Character> iter = myStr.iterator();
		while(iter.hasNext()) {
			char c = iter.next();
			if(c=='e') iter.remove();
		}
		System.out.println(myStr);
		myStr.addChar('!');
		System.out.println(myStr);
	}
	
	

}
