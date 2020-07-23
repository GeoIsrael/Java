package telran.person.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

import telran.person.model.Person;

public class PersonMap implements IPerson {
	Map<Integer, Person> persons = new HashMap<>();
	ReadWriteLock rwLock = new ReentrantReadWriteLock();
	Lock readLock = rwLock.readLock();
	Lock writeLock = rwLock.writeLock();

	@Override
	public boolean addPerson(Person person) {
		try {
			writeLock.lock();
			return persons.putIfAbsent(person.getId(), person) == null;
		} finally {
			writeLock.unlock();
		}
	}

	@Override
	public Person findPerson(int id) {
		try {
			readLock.lock();
			return persons.get(id);
		} finally {
			readLock.unlock();
		}
	}

	@Override
	public List<Person> getAllPersons() {
		try {
			readLock.lock();
			return new ArrayList<>(persons.values());
		} finally {
			readLock.unlock();
		}
	}

}
