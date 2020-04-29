package telran.regexp;

public class StringMatcher {

	public static boolean isTrue(String string) {
		return string.matches("[Tt]rue");
	}

	public static boolean isNumber(String string) {
		return string.matches("\\d+");
	}

	public static boolean isThreeNumber(String string) {
		return  string.matches("[\\d][\\d][\\d]");
	}

	public static boolean isWord(String string) {
		return string.matches("[a-zA-Z][a-z]*-?[a-z]+");
	}

	public static boolean isJavaName(String string) {
		return string.matches("[a-zA-Z_]\\w*");
	}

	public static boolean isLessThen1000(String string) {
				return string.matches("\\d{1,3}");
	}

	public static boolean isLessThen300(String string) {
		return string.matches("[12]?\\d{1,2}?");
	}

}
