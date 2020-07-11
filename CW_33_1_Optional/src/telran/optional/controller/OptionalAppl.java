package telran.optional.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import telran.optional.model.Person;



public class OptionalAppl {
	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(new Person("Alex", 25),     //создаем List Persons
				new Person("John", 28), new Person("Maria", 17));        //способ создания листа imutable (не изменяемый) ограниченная длина   
		int age = 20;                                              //var 
		Optional<Person> result = findPersonByAge(persons, age);    //метод принимает Liss, возраст и возвращает первого попавшегося person у которого есть этот возраст
//		Person person = result.orElse(new Person("Unknown", -1));   //4 вариант использования Optional - возвращает готовый объект
//		Person person = result.orElseGet(() -> new Person("Unknown", -1));   //5 вариант использования Optional - возвращает объект с какими то выполненными действиями (функцией)		
		Person person = result.orElseThrow(IllegalArgumentException::new);   //6 вариант использования Optional c созданием Exception
		System.out.println(person.getName());
	}

	//Optional это обертка, внутри которой режит или результат или null
	//
	
	private static Optional<Person> findPersonByAge(List<Person> persons, int age) {   
		Person res = null;
		for (Person person : persons) {                 
			if (person.getAge() == age) {
				res = person;
				break;
			}
		}
		return Optional.ofNullable(res);  
		// два способа создания Optional
		//1: return Optional.of(Person) + Optional.of(null)  - !!!!!!!!!!!!в метод of null класть нельзя
		//2: return Optional.ofNullable(res);  - правильное использование
		
		//использование Optional
		//if    ---->   result.isPresent()   этот метод возвращает true если в переменной что либо есть
		
		//1) result.ifPresent(System.out::println);    //если внутри result что то присутствует, то выполни вот эту функцию
		//2) result.ifPresent(e -> System.out.println(e.getName()));
		//3) result.ifPresent(e -> {
		                        //System.out.println(e.getName());
		                        //System.out.println(e.getAge());
        //	                    });
		//4) этот вариант использования Optional в коде
		//consumer это потребитель - если результат есть, то выполни действие которое есть внутри
		//ifPresent нужен для обработки результата здесь и сейчас
		//supplier из ничего делает что то 
	}
}
