package telran.person.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Child extends Person {
	
	String kindergarden;

	public Child(int id, String name, LocalDate birthDate, Address address, String kindergarden) {
		super(id, name, birthDate, address);
		this.kindergarden = kindergarden;
	}

	@Override
	public String toString() {
		return "Child [kindergarden=" + kindergarden + ", id=" + id + ", name=" + name + ", birthDate=" + birthDate
				+ ", address=" + address + "]";
	}
	
	
	
	
	
}
