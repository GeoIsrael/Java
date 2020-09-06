package telran.ashkelon2020.person.service;

import telran.ashkelon2020.person.dto.PersonDto;

public interface PersonService {
	
	boolean addPerson(PersonDto personDto);
	
	PersonDto findPersonById(Integer id);

}
