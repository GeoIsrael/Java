package telran.mpre;

public class MyRegExp {
    //0-255 equals
	public static boolean is255(String string) {
		return string.matches("1?\\d?\\d|2[0-4]\\d|25[0-5]");
	}
	
	//ipv4 equals
	public static boolean isIpv4(String string) {
		return string.matches("((1?\\d?\\d|2[0-4]\\d|25[0-5])\\.){3}(1?\\d?\\d|2[0-4]\\d|25[0-5])");
	}
	
	
	//israel mobile phone equals
	public static boolean isIsraelMobile(String string) {
		String regex = "(\\+972-?5[0-8]-?|05[0-8]-?)(\\d-?){7}";
		return string.matches(regex);
	}

	public static boolean isEmailMailRu(String string) {
		String regex = "(\\w)+[@]mail\\.ru";
		return string.matches(regex);
	}
	
	//isTime 00:00 - 23:59
	public static boolean isTime(String string) {
		String regex = "(2[0-3]|[0-1]\\d):[0-5]\\d";
		return string.matches(regex);
	}
	
	//isColor HEX
	public static boolean isColor(String string) {
		String regex = "#[0-9a-fA-F]{6}";
		return string.matches(regex);
	}
	
	//isArithmetic   
	public static boolean isArithmetic(String string) {
		String regex = "\\s*[-]?\\s*\\d+(\\s*[-+*/]\\s*\\d+)*\\s*" ;
		return string.matches(regex);
		}
	
	
	
	
	
	
}

//Pattern pattern = Pattern.compile("\\s*(\\s|,|!|\\.)\\s*");


//Разбивка текста по словам=========================================================
//String text = "FIFA will never regret it";
//String[] words = text.split("\\s*(\\s|,|!|\\.)\\s*");
//for(String word : words){
//    System.out.println(word);
//}





