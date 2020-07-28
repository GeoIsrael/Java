package telran.persons.dao;

import java.util.Collection;

import telran.persons.model.Person;

public interface IPersons {
	boolean addPerson(Person person);
	
	Person getPerson(int id);
	
	Collection<Person> getAllPersons();
}
