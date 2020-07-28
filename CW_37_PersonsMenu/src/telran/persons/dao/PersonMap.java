package telran.persons.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import telran.persons.model.Person;

public class PersonMap implements IPersons {
	Map<Integer, Person> persons = new HashMap<>();

	@Override
	public boolean addPerson(Person person) {
		return persons.putIfAbsent(person.getId(), person) == null;            //добавлем персону если ее нет
	}

	@Override
	public Person getPerson(int id) {
		return persons.get(id);
	}

	@Override
	public Collection<Person> getAllPersons() {
		return persons.values();
	}

}
