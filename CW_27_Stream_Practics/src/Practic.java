import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Practic {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(10,-4,20,8,7,2,3);
//		displayListWithIndexes(list);                       //распечатываем лист и индексами
//		displayCharOccurrances("aaaacfcffdgthththt");       //создаем мапу вхождений символов
		displayEvenOddSums(list);                           //на вход list - на выходе сумма четных и сумма нечетных

	}

	private static void displayEvenOddSums(List<Integer> list) {   //ключ even - значения сумма, ключ odd - значение сумма
	list.stream()                                            //лист запускаем в стрим
	.collect(Collectors.groupingBy(n->n%2==0?"even":"odd", Collectors.summingInt(n->n)))    //раз мепа - значит groupingBy. если число четное - возвращаем even, нечетное то odd.
	                                                       //суммируем числа в значении по группам
	.forEach((k,v)->System.out.printf("%s:%d\n",k,v));     //выводим на консоль
		
	}

	private static void displayCharOccurrances(String string) {     //
		Arrays.stream(string.split(""))                             //запускаем стрим массива символов
		.collect(Collectors.groupingBy(s->s,Collectors.counting()))  //собираем мапу методом groupingBy
		.forEach((k,v)->System.out.printf("%s -> %d\n",k,v));        //распечатываем мапу
		
	}

	private static void displayListWithIndexes(List<Integer> list) {
		IntStream.range(0, list.size())                                //Формируем поток чисел в диапазоне от 0 до size
		.forEach(i->System.out.printf("%d -> %d\n", i, list.get(i)));  //распечатываем
		
	}

}
