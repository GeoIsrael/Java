package telran.person.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString

public class Address {

	String city;
	String street;
	int building;
	int aprt;
	
	
	
	
}
