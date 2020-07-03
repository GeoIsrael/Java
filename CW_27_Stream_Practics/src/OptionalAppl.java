import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalAppl {

	public static void main(String[] args) {

		List<Person> persons = Arrays.asList(new Person("Alex", 25), new Person("John", 28), new Person("Maria", 17));

		int age = 22;

		Optional<Person> optional = findPersonByAge(persons, age);   //объект Optional это класс обертка для null

		try {

			System.out.println(optional.orElseThrow(() -> new ArrayIndexOutOfBoundsException()));
			                  //если вдруг нет объекта, то будем бросать исключение, а какое будем решать сами

		} catch (Exception e) {
			System.out.println(e.getMessage());     //поймаем наше исключение и выведем его 
			e.printStackTrace();                    //распечатаем информацию по исключени
		}
        
		System.out.println("End of programms");
        
    }

	private static Optional<Person> findPersonByAge(List<Person> persons, int age) {
		for (Person person : persons) {
			if (person.getAge() == age)
				return Optional.ofNullable(person);
		}
		return Optional.ofNullable(null);
	}

//	public static Optional ofNullable(value)
//	{
//		return vlaue==null?empty():of(value);
//	}

}
