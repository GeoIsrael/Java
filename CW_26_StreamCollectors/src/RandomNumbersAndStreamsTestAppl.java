import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomNumbersAndStreamsTestAppl {
	private static final long N_NUMBERS = 20;
	private static final long N_LISTS = 30;

	public static void main(String[] args) {
		sportLoto(1,49);                    //генерируем 7 чисел от 1 до 49 при помощи лямбд
		
		List<List<Integer>> lists = getLests();    //лист, типизированный листом Integer = берется из метода getLests
		System.out.println("sum= " + getSum(lists));   //выводим сумму листа листов
		evenOddMap(lists);       //из листа листов создаем мепу где  при помощи partitioningBy - метод Collectors
	}                            //суть метода в том, что в зависимости от предиката знначения будут попадать или в один лист или в другой 

	private static void evenOddMap(List<List<Integer>> lists) {
		lists.stream()                 //запускаем стрим листа
		.flatMap(List::stream)          //распаковываем внутренние листы
		.collect(Collectors.partitioningBy(n->n%2==0))        //собираем мепу: в коллекторах есть коллектор partitioningBy -> у мепы два ключа - ключ TRUE и ключ FALSE
		.forEach((k,v)->System.out.println(k +" -> " + v));   //
		
	}

	private static long getSum(List<List<Integer>> lists) {       
		
		return lists.stream()         //запускаю стрим листа
				.flatMap(List::stream).mapToLong(n->n.longValue()).sum();  //flatmap - заходит лист - на выходе стрим из листа, преобразуем поток в лонги, суммируем поток
	}

	private static List<List<Integer>> getLests() {   //данный метод генерирует лист листов псевдослучайных значений от 1 до 200 количеством N.NUMBERS 
		
		return Stream.                 //у класса Stream есть метод generate, который начинает Stream
				generate( ()->new Random().ints(N_NUMBERS, 1, 200).boxed().collect(Collectors.toList()))    //метод generate создает рандомайзер, который генерирует стрим псевдослучайных примитивов, которые превращаем в объекты и собираем в List
				.limit(N_LISTS)     //ограничиваем количество импульсов generate
				.collect(Collectors.toList());   //и собираем их в List
	}

	private static void sportLoto(int min, int max) {
		new Random().ints(min, max+1).distinct().limit(7)    //генерация Stream примитивов из new Random. огриничивем не повторяющимися  7 значений
		.forEach(n->System.out.print(n + " "));         //распечатываем числа
		
	}

}
