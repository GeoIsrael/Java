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
		boolean length_pass = wrongLength(password); //check password length
		boolean wrong_up_case = wrongUppercase(password); //check UpperCase
		boolean wrong_low_case = wrongLowercase(password); //check LowerCase
		boolean wrong_dig = wrongDigit(password); //check Digit
		boolean wrong_spec = wrongSpecSymbol(password); //Check SpecSymbol
		
		System.out.println(length_pass + "\t" + wrong_up_case + "\t"+ wrong_low_case + 
				"\t" + wrong_dig + "\t" + wrong_spec);
		
		return true;
		
	}

	private static boolean wrongSpecSymbol(String password) {
		char[] array=password.toCharArray();
		for(char x: array) {
			if (Character.isLetter(x) || Character.isDigit(x)) continue;
            return true;		
		}
		return false;
		
	}

	private static boolean wrongDigit(String password) {
		char[] array=password.toCharArray();
		for(char x: array) {
			if (Character.isDigit(x)) return true;
            continue;		
		}
		return false;
		
	}

	private static boolean wrongLowercase(String password) {
		char[] array=password.toCharArray();
		for(char x: array) {
			if (Character.isLowerCase(x)) return true;
            continue;		
		}
		return false;
		
	}

	private static boolean wrongUppercase(String password) {
		char[] array=password.toCharArray();
		for(char x: array) {
			if (Character.isUpperCase(x)) return true;
            continue;		
		}
		return false;
		
	}

	private static boolean wrongLength(String password) {
		if (password.length() >= 8) return true;
		return false;
	}

}
