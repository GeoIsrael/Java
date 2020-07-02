import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import java.util.TreeSet;
import java.util.stream.Collectors;

public class Program {

	public static void main(String[] args) {
		List<String> phones = new ArrayList<>();  //создаем коллекцию и наполняем ее методом addAll
		Collections.addAll(phones, "iPhone 8", "HTC U12", "Huawei Nexus 6P", "Samsung Galaxy S9", "LG G6",
				"Xiaomi MI6", "ASUS Zenfone 2", "Sony Xperia Z5", "Meizu Pro 6", "Lenovo S850","Siemens A35",
				"Nokia 3310");
		
		List<String> filteredPhones = phones.stream() //запускаем стрим  phones
				.filter(s->s.length()<10)       //фильтруем по длиен строки > 10
				.collect(Collectors.toList());  //собрать выход в List
		
//		for(String s : filteredPhones)     //распечатка листа forEach обычным
//		{
//			System.out.println(s);
//		}
		
		filteredPhones.forEach(System.out::println);    //распечатка List соственным методом forEach
		
			phones.stream()                          //запускаем поток из phones
				.filter(s->s.length()<10)            //фильтруем строки меньше 10 символов
				.collect(Collectors.toSet())         //собираем их в Set
				.stream().filter(s->s.contains("8"))  //Запускаем Set в стрим, фильтруем объекты содержащие 8
				.forEach(System.out::println);       //распечатывем поток
			
		Map<String, Integer> phonesMap = phones.stream()               //в мапу из потока
				.collect(Collectors.toMap(s->s, s->s.length()));       //создаем коллекцию из ключей наименований и значений - длинн строки

//		for(Entry<String, Integer> entry : phonesMap.entrySet())       //рапечатка внешним forEach
//		{
//			System.out.println(entry.getKey()+" - "+entry.getValue());
//		}
		
		phonesMap.forEach((k,v)->System.out.println(k + " - " + v));    //распечатка Map собственным forEach
		
		
		
		
		TreeSet<String> filteredPhonesSet = phones.stream()     //Делаем TreeSet: запускаем стрим из phones
				.filter(s->s.length()<12)                       //пропускаем только тех у кого длина названия < 12
				.collect(Collectors.toCollection(TreeSet::new));//()->new TreeSet()      //у стрима вызываем метод collect от класса Collectors
																		//задача данного Supplier это сделать какую то коллекцию - какую м сами решаем
		System.out.println("===========================================");
		filteredPhonesSet.forEach(System.out::println);

	}
	
	

}
