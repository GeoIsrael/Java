//1. В проекте PasswordCheck (вы можете узнать его в выпадающем списке) есть структура домашнего 
//задания с контрольными примерами. Вы должны написать метод passwordCheck в классе Password (// TODO) 
//		таким образом, чтобы все тесты были пройдены. Объяснения метода можно найти в комментариях к 
//		тестовому сценарию «rightPassword».
// * at least 8 symbols
//	 * at least one uppercase letter
//	 * at least one lowercase letter
//	 * at least one digit
//	 * at least one symbol from the following[*,&,%,!,@]

public class Password {
	public static boolean passwordCheck(String password){
		
		System.out.println(password);
		boolean length_pass = wrongLength(password); 
		boolean wrong_up_case = wrongUppercase(password); 
		boolean wrong_low_case = wrongLowercase(password); 
		boolean wrong_dig = wrongDigit(password); 
		boolean wrong_spec = wrongSpecSymbol(password); 

		if(length_pass && wrong_up_case && wrong_low_case && wrong_dig && wrong_spec) return true;
		
		return false;
		
	}

	private static boolean wrongSpecSymbol(String password) {  

	       boolean isSpec = false;     
	       char[] my_chars = password.toCharArray();
	            for (int i = 0; i < my_chars.length; i++) {
	                if (my_chars[i] == '*' || my_chars[i] == '&' || my_chars[i] == '%' || my_chars[i] == '!'
	                		|| my_chars[i] == '@') isSpec = true;
	                
	            }
	            return isSpec;

		
	}

	private static boolean wrongDigit(String password) {
		char[] array=password.toCharArray();
		for(char x: array) {
			if (Character.isDigit(x)) return true;		
		}
		return false;
		
	}

	private static boolean wrongLowercase(String password) {
		char[] array=password.toCharArray();
		for(char x: array) {
			if (Character.isLowerCase(x)) return true;	
		}
		return false;
		
	}

	private static boolean wrongUppercase(String password) {
		char[] array=password.toCharArray();
		for(char x: array) {
			if (Character.isUpperCase(x)) return true;	
		}
		return false;
		
	}

	private static boolean wrongLength(String password) {
		if (password.length() >= 8) return true;
		return false;
	}

}
