package telran.ashkelon2020.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import telran.ashkelon2020.dto.EmployeeDto;
import telran.ashkelon2020.dto.EmployeeTaxDto;

@RestController
@RequestMapping("/person")
public class SimpleServiceController {

	@GetMapping("/greeting")
	public String greeting(String name, Integer age) {
		return "Hello " + name+ ", your age = " + age;
	}
	
	@PostMapping("/greeting")
	public String greetingPerson(@RequestBody EmployeeDto employee) {
		return "Hello " + employee.getFirstName() + " " + employee.getLastName() 
		+ ", your salary = " + employee.getSalary();
	}
	
	@PostMapping("/tax/minsalary/{min}/taxrate/{rate}")
	public EmployeeTaxDto calcTax(@RequestBody EmployeeDto employee, 
			@PathVariable Integer min, @PathVariable Integer rate) {
		double tax = 0;
		if (employee.getSalary() > min) {
			tax = (employee.getSalary() - min) * rate / 100.;
		}
		return EmployeeTaxDto.builder()
				.firstName(employee.getFirstName())
				.lastName(employee.getLastName())
				.salary(employee.getSalary())
				.tax(tax)
				.build();
		
	}

}
