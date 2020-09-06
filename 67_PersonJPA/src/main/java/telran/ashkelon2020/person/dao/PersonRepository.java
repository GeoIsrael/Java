package telran.ashkelon2020.person.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import telran.ashkelon2020.person.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
