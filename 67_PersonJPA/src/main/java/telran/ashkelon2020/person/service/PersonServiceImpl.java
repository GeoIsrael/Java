package telran.ashkelon2020.person.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.ashkelon2020.person.dao.PersonRepository;
import telran.ashkelon2020.person.dto.PersonDto;
import telran.ashkelon2020.person.model.Person;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public boolean addPerson(PersonDto personDto) {
		Person person = modelMapper.map(personDto, Person.class);
		personRepository.save(person);
		return true;
	}

	@Override
	public PersonDto findPersonById(Integer id) {
		Person person = personRepository.findById(id).orElse(null);
		return modelMapper.map(person, PersonDto.class);
	}

}
