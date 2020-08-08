package telran.test;

import java.util.Comparator;

public class DateComparator implements Comparator<String> {

	@Override
	public int compare(String arg0, String arg1) {
		
		String res1 = "";    //две пустые строки
		String res2 = "";
		
		String[] temp1 = arg0.split("-");     //сплитим входную строку в массив строк
		String[] temp2 = arg1.split("-");
		
		for (int i = temp1.length -1; i >= 0; i--) {
			res1 += temp1[i];             //конкатенирую строку (убираю "-") из входа
			res2 += temp2[i]; 
		}
		
		return Integer.parseInt(res1) - Integer.parseInt(res2)   ;
	}

}


//1) рассплитить строку
//2) превратить ее в строку наоборот
//3) сравнить две строки
//4) вернуть значение