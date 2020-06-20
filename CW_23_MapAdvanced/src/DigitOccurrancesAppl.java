import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.function.BiFunction;

public class DigitOccurrancesAppl {
	private static int N_NUM = 1_000_000;          //количество генераций рандомных чисел
	private static Random rnd = new Random();      //на основе объекта класса Random

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();   //создаем Map 
		
		for(int i=0;i<N_NUM;i++)                      //в цикле
		{
			int number = rnd.nextInt(999_999_999);        //генерим числа в диапазоне от 0 до 999999999
			String[] digits = Integer.toString(number).split("");   //разбиваем число на цифры и записываем его в массив стрингов 
			for(int j=0;j<digits.length;j++)        //итерируем массив числа посимвольно
			{   //метод merge() имеет 3 параметра - (ключ, значение, BiFunction) если в Map ключа Key не существует или Value == null, то данный метод добавляет в Map пару, которую мы передаем. Если ключ Key существует и его Value != null, то в этом случае Value меняется на результат функции remappingFunction - реализация некоторого интерфейса BiFunction
				map.merge(digits[j], 1, new BiFunction<Integer, Integer, Integer>() {  //обычно берется старое значение, новое значение и производится какая то логика 
                                                                 //если remappingFunction возвращает null, то пара удаляется из коллекции
																 //dв качестве ключа используем один символ из числа, в качестве значения - 1, 
					@Override
					public Integer apply(Integer t, Integer u) {    //если ключ существует и значение его отлично от нуля, то он поменяет ключ на результат работы метода apply
						                                            //t - это старое значенние пары, u - новое значение (в нашем случае ==1)
						return t+u;                                //возвращаем новое значение. Если такой пары ключ значение нет, то merge не будет вызывать BiFunction, он просто создаст пару (digits[j], 1)
					}
				});
			}
		}
		Set<Entry<String, Integer>> set = map.entrySet();           //далее делаем Set пар
		List<Entry<String, Integer>> entries = new ArrayList<>(set); //делаем на базе сета лист
		entries.sort(new Comparator<Entry<String, Integer>>() {      //сортируем лист по компаратору

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				
				return o2.getValue()-o1.getValue();    //компаратор
			}
		});
		
		for(Entry<String, Integer> entry:entries)           //и выводим на печать
		{
			System.out.println(entry.getKey() + " => "+entry.getValue());
		}

	}

}
