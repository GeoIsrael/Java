import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamAppl {

	public static void main(String[] args) {
		Set<Integer> numbers = new HashSet<>(Arrays.asList(5,7,9,1));
		for(Integer n:numbers)
		{
			if(n%2!=0)
			System.out.print(n + " ");
		}
		System.out.println();
		
		numbers.stream()
		.filter(n->n%2!=0)
		.forEach(n->System.out.print(n + " "));		
		System.out.println();
		
		System.out.println("First even element: " + numbers.stream()
		.filter(n->n%2==0)
		.findFirst().orElse(100500));      //вернуть первое четное или 100500
		
		System.out.println(getRandomNumbers(20));
	}
	
	private static List<Integer> getRandomNumbers(int n_numbers)
	{
		return new Random().ints(1,Integer.MAX_VALUE)    //Новый рандомайзер .ints (4 реализации ints) от 1 до IntMaxValue
				.limit(n_numbers)        //ограничение сколько цифр
				.boxed()                 //сейчас идет стрим примитивов. для того чтобы перевести ихв Integer нужно выполнить Wrapper метод .boxed()
				.collect(Collectors.toList());  //и после этого собрать их в лист
	}

}
