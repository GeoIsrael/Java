//Написать класс с методами:
//
//1) public static void printStringInColumnInRange(String str,int start,int finish)
//метод выводит в колонку на консоль строку в диапазоне от start до finish включительно.
//
//2) public static boolean isCharExists(String str,char c)
//метод возвращает true если символ в строке есть или false если нет.
//
//3) public static void printStrReverse(String str)
//метод выводит на консоль строку в реверсе.
//
//3)* public static String strReverse(String str)
//метод возвращает строку в реверсе!
//
//4)*public static boolean palindrome(String str1 , String str2)
//Функция принимает две строки и возращает true если они палиндромы или  false если нет




public class StringIntr {

	public static void main(String[] args) {
		

		String str = "Hello world";
		StringMethods.PrintStr(str);
		
//		Задача 1		
		int start = 3, finish = 4;
		StringMethods.printStringInColumnInRange(str,start,finish);
		
//      Задача 2		
		char c = 'l';
		System.out.print("Нахождение символа в строке: " + StringMethods.isCharExists(str,c) + "\n");
		
//      Задача 3
		StringMethods.printStrReverse(str);
		
//      Задача 3+
		String reverseString = StringMethods.strReverse(str);
		System.out.println(reverseString);
		
//      Задача 4
		String str1 = "Abcd", str2 = "dcbA";
		System.out.print("Строки являются палиндромами: " + StringMethods.palindrome(str1 , str2));

	}

}
