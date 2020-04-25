
public class MainApp {

	public static void main(String[] args) {
		System.out.println(42);

		//сравнение строки на уникальность символов
		String line = "aaabccdddcFF";
        System.out.println( line.chars().distinct().count() );


        //Первые буквы слова в верхний регистр
        line = "организация объединённых наций";
        char[] chars = line.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i == 0 || chars[i - 1] == ' ') {
                chars[i] = Character.toUpperCase(chars[i]);
            }
            }
            System.out.println(new String(chars));
                
       //проверка пароля на спецсимволы 
       line = "hnnfhdgghoo";
       boolean isSpec = false;     
       char[] my_chars = line.toCharArray();
            for (int i = 0; i < my_chars.length; i++) {
                if (my_chars[i] == '!' || my_chars[i] == '*' || my_chars[i] == '#') isSpec = true;
                
            }
            System.out.println(isSpec);
            
       System.out.println("===============");
            
       Strings.mys_compare();
            
            
	}

}
