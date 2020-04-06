
public class StringMethods {

	public static void PrintStr(String str) {
		System.out.print("Строка: " + str + "\n");
	
	}
	
	public static void printStringInColumnInRange(String str,int start,int finish) {
		for(int i = start; i <= finish; i++) System.out.println(str.charAt(i));
		
		
	}
	
	public static boolean isCharExists(String str,char c) {
		for(int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == c) return true;
		}
		return false;
	}
	
	
	public static void printStrReverse(String str) {
		for(int i = str.length() - 1; i >= 0 ; i--) System.out.print(str.charAt(i));
	    System.out.println(" ");
	}
	
	
	public static String strReverse(String str) {
	    String Result = "";
	    for(int i = str.length() - 1; i >= 0 ; i--) Result += str.charAt(i);
	    return Result;
	}
	
	public static boolean palindrome(String str1 , String str2) {
		if (str1.length() != str2.length()) return false;
		for (int i = 0, y = str2.length() - 1; i < str1.length() ; i ++ , y --) {
		    if (str1.charAt(i) != str2.charAt(y)) return false;	
		}
		return true;
	}
	
	
}
