import java.util.Arrays;

import java.util.stream.Collectors;

public class StringsCountAppl {

	public static void main(String[] args) {
		
		String txt = "lmn, vf ab a lmn: ab lmn";
		//lmn -> 3
		//ab -> 2
		//a -> 1
		//vf -> 1
		displayWordCounts(txt);         //подсчитаем количество слов в тексте
	}

	private static void displayWordCounts(String txt) {
		String[] words = getWords(txt);                                            //получаем массив строк
//		Map<String,Long> map = Arrays.stream(words)                
//				.collect(Collectors.groupingBy(s->s,Collectors.counting()));              //так выглядит мепа вхождений
		
		Arrays.stream(words)                                               //запускаем стрим из массива слов
		.collect(Collectors.groupingBy(s->s,Collectors.counting()))        //собираем его в мепу вхождений через groupingBy
		.entrySet().stream()                                               //преобразуем мепу через entrySet в коллекцию обычных entries, и запускаем у него стрим
		.sorted((e1,e2)->e1.getValue()==e2.getValue()?                     //сортируем через компаратор (энтрис1, энтрис2) -> сравнение с досравнением через тернаный оператор
				e1.getKey().compareTo(e2.getKey()):                        //если значения равны, сравниваем ключи
					Long.compare(e2.getValue(), e1.getValue()))            //если значения не равны, сравниваем значения Long
		.forEach(e->System.out.println(e.getKey() + " -> " + e.getValue()));   //распечатываем 

		
	}

	private static String[] getWords(String txt) {                
		
		return txt.split("[^A-Za-z]+");
	}

}
