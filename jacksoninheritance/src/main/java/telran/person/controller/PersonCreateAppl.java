package telran.person.controller;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import telran.person.model.Address;
import telran.person.model.Child;
import telran.person.model.Employee;
import telran.person.model.Person;

public class PersonCreateAppl {
	static ObjectMapper mapper;
	static {
		mapper  = new ObjectMapper();
//		mapper.registerModule(new JavaTimeModule());
		mapper.findAndRegisterModules();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	public static void main(String[] args) throws JsonProcessingException {

	
		Person[] persons =  {
			new Child(1000, "Moshe", LocalDate.of(2015,5,15), 
					new Address("C1", "S1", 10, 20), "Shalom"),
			new Employee(2000, "Sara", LocalDate.of(1990, 9, 20), 
					new Address("Ashdod", "street2", 23, 23), "company1", 10000),
			new Person(3000, "Boris", LocalDate.of(1190, 10, 1), 
					new Address("Moskow", "Herzel", 2, 3))
			
		};
		
		String jsonString = mapper.writeValueAsString(persons);
		System.out.println(jsonString);
		
		List<Person> personsRestore = mapper.readValue(jsonString, new TypeReference<List<Person>>() {
		});
		personsRestore.forEach(System.out::println);
		
		
		
	}

}
