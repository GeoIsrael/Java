import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;


public class FunctionalProgrammingAppl {

	public static void main(String[] args) {
		
		Map<String,BinaryOperator<Integer>> map = new HashMap<>();   //создаем Мап, где ключ это строка, а значение - BinaryOperator (он всегда типизируется Integer)
		map.put("*", (a,b)->a*b);                                      //добавляем в Мапу ключ *, а значение - действие     //функциональные интерфейсы можно посмореть в JavaUtilFunction пакете
		System.out.println(map.get("*").apply(10, 30));
		
		
		//===================================Lambda Expression=======================
		
		
		List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,10,5,-4,20));   //создаем List 
		//find even numbers
		System.out.println("even numbers "+find(list, e->e%2==0));      //в метод find передаем list и предикат - lambda
		//find odd numbers
		System.out.println("odd numbers "+find(list, e->e%2!=0));
		
		
		//=======================Lambda Block========================================
		
		list.sort((a,b)->{                      
			if(a%2==0&&b%2!=0) return -1;                //нестандартный компаратор в лямбда блоке
			if(a%2!=0&&b%2==0) return 1;
			if(a%2==0&&b%2==0) return a-b;
			return b-a;
		});
		System.out.println(list);
		//======================Method Reference====================================
		list.sort(Integer::compare);        //Integer(к какому классу обращаемся) :: compare у Integer (вместо compare можно передать другие компаработы)   
		System.out.println(list);
		
	}

	private static List<Integer> find(List<Integer> list, Predicate<Integer> predicate) {     //import predicate from JavaUtilFunction
		List<Integer> res = new ArrayList<>();    //создаем возвращаемый лист
		for(Integer num:list)                //в цикле
		{
			if(predicate.test(num)) res.add(num);        //сравниваем на соответствие предикату - те элементы, которые подходят, добавляются в res
		}
		return res;
	}

}
