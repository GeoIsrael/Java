
public class Strings {

		
	public static void mys_compare() {
	
	    String test1 = "literal";
	    String test2 = new String("literal");
	    System.out.println(test1 == test2);
				
		test1 = "literal";
	    test2 = new String("literal").intern();
	    System.out.println(test1 == test2);
	    
	    
	    test1 = "literal";
	    test2 = new String("literal").intern();
	    System.out.println(test1.equals(test2));
	    
	
	}
	
	
	
}

	
