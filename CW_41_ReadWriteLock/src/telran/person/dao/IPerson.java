package telran.person.dao;

import java.util.List;

import telran.person.model.Person;

public interface IPerson {

	boolean addPerson(Person person);

	Person findPerson(int id);

	List<Person> getAllPersons();

}
