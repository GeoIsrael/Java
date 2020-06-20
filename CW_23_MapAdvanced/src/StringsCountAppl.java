import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class StringsCountAppl {

	public static void main(String[] args) {
		String text = "lmn, vf ab a lmn: ab ab lmn";           //проект разбирает эту строку по словам 
		/*
		 * lmn - > 3
		 * ab - > 2
		 * a - > 1
		 * vf - > 1
		 */
		dysplayWordCounts(text);                               //метод отображает слова 

	}

	private static void dysplayWordCounts(String text) {
		String[] words = getWords(text);                       //получаем массив слов из метода getWords()
		HashMap<String, Integer> mapOccurrances = getMapOccurrances(words);    //создаем HashMap, в которую помещаем слова как ключ (потому что они не повторяются) а значение - сколько раз слово встретилось в массиве.
//так как в HashMap (и в TreeMap) идет сортировка по ключу, а нам нужно сортировать по значению:
		List<Entry<String, Integer>> listOccurrances = getListOccurrances(mapOccurrances); //нужно из Map сделать List (нужен лист EntrySet - пара ключ и значение), те. List объектов Entry
		sortListOccurrances(listOccurrances);   //сортируем полученный лист
		displaySortedList(listOccurrances);     //отображаем полученную информацию
		
		
	}

	private static void displaySortedList(List<Entry<String, Integer>> listOccurrances) {
		for(Entry<String, Integer> entry : listOccurrances)             //итерируем
		{
			System.out.printf("%s - > %d\n", entry.getKey(), entry.getValue());      //и распечатываем
		}
		
	}

	private static void sortListOccurrances(List<Entry<String, Integer>> listOccurrances) {   //Сортировка. Получаем лист
		listOccurrances.sort(new Comparator<Entry<String, Integer>>() {       //у всек коллекций есть метод sort c компаратором в анонимном типизированном иннер-классе.

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {      //компаратор типизирован Entrys
				int res = o2.getValue()-o1.getValue();                                //так как у нас идет сортировка по значению (в обратном порядке)
				return res==0?o1.getKey().compareTo(o2.getKey()):res;                 //если res == 0 то сравнение лексиграфическое
			}
		});
		
	}

	private static List<Entry<String, Integer>> getListOccurrances(HashMap<String, Integer> mapOccurrances) {
		
		return new ArrayList<>(mapOccurrances.entrySet());      //из Map получаем List и возвращаем его. Метод entrySet() возвращает Set Entrys
	}

	private static HashMap<String, Integer> getMapOccurrances(String[] words) {
		HashMap<String, Integer> res = new HashMap<>();           //создаем карту HashMap  с парой ключ/значение
		for(String word:words)                                    //итерируем массив words
		{
			//метод getOrDefault это метод, если такая пара есть, то возвращаем число по умолчанию (в нашем случае 0), если первый раз - стартуем с 0)
			int count = res.getOrDefault(word, 0);                //counter =  
			res.put(word, count+1);                               //добавление в Map - слово и количество сколько раз оно встретилось. Put перезапишет значение count
		}
		return res;               //возвращаю Map вхождений
	}

	private static String[] getWords(String text) {          //метод расспличивает строку по словам
		
		return text.split("[^A-Za-z]+");                     //разделитель все кроме букв, один или более раз
	}

}
