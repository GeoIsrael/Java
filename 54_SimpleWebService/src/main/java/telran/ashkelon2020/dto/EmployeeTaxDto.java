package telran.ashkelon2020.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeTaxDto {
	String firstName;
	String lastName;
	Integer salary;
	Double tax;

}
