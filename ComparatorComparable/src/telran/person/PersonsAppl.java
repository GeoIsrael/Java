package telran.person;

import java.util.Arrays;

public class PersonsAppl {

	public static void main(String[] args) {

		Person per1 = new Person(1999, "Olga");
		
		Person [] persons = {
			new Person(1979, "Vasya"),
			new Person(1980, "Vasya"),
			new Person(1992, "Petya"),
			new Person(1980, "Izya"),
			new Person(1980, "Afka"),
			new Person(1989, "Masha"),
			per1
		};
		
		printPersons(persons);
		Arrays.sort(persons);
		printPersons(persons);
	}

	private static void printPersons(Person[] persons) {
		for (Person i: persons) {
			System.out.println(i.toString() + " ");
		}
		System.out.println();
	}

}
