package telran.security;

public class PasswordCheck {
	
	private static final int PASSWORD_LENGTH = 8;
	
	public static final String WRONG_SYMBOL_MESSAGE = "wrong symbol";          // Определение констант
	public static final String WRONG_LENGTH_MESSAGE ="wrong length";
	public static final String NO_SPEC_SYMBOL_MESSAGE = "no spec symbol";
	public static final String NO_UPPER_CASE_MESSAGE = "no upper case";
	public static final String NO_LOWER_CASE_MESSAGE = "no lower case";
	public static final String NO_DIGIT_MESSAGE = "no digit";
	 static final String[] MESSAGES= {
		NO_UPPER_CASE_MESSAGE,NO_LOWER_CASE_MESSAGE,
		NO_DIGIT_MESSAGE,NO_SPEC_SYMBOL_MESSAGE
		
	};
	 static final int UPPER_CASE_INDEX=0;                                       //набор флагов
	 static final int LOWER_CASE_INDEX=1;
	 static final int DIGIT_INDEX=2;
	 static final int SPEC_SYMB_INDEX=3;

	private static final int N_FLAGS = 4;
	static boolean[] flags; 
	 
	
public static void check(String password) throws IllegalPasswordException  {       //проверка на null
	flags=new boolean[N_FLAGS];
	if(password==null)
		throw new IllegalArgumentException("null");
	
	if(password.length()<PASSWORD_LENGTH)                                             //проверка длины
		throw new IllegalPasswordException(new String[] {WRONG_LENGTH_MESSAGE});
	for (char symb:password.toCharArray()) {                                           //перебор массива символов
		if(Character.isWhitespace(symb))                                               //и проверка с установкой флагов 
			throw new IllegalPasswordException
			(new String[] {WRONG_SYMBOL_MESSAGE});
		if (Character.isUpperCase(symb))
			flags[UPPER_CASE_INDEX]=true;
		else if(Character.isLowerCase(symb))
			flags[LOWER_CASE_INDEX]=true;
		else if(Character.isDigit(symb))
			flags[DIGIT_INDEX]=true;
		else
			flags[SPEC_SYMB_INDEX]=true;
	}
	int countErrors=getCountErrors();                                                
	if(countErrors!=0)
		throw new
		IllegalPasswordException(getMessages(countErrors));
}
private static String[] getMessages(int countErrors) {
	String res[]=new String[countErrors];
	int ind=0;
	for(int i=0;i<flags.length;i++) {                             //алгоритм выборки из одного массива в в другой
		if(!flags[i])
			res[ind++]=MESSAGES[i];
	}
	return res;
}
private static int getCountErrors() {                             //счетчик количества ошибок ввода
	int count=0;
	for(boolean flag:flags) {
		if(!flag)
			count++;
	}
	return count;
}
}
