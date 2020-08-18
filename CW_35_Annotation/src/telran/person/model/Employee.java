package telran.person.model;

import java.time.LocalDate;

import telran.utils.annotation.Id;
import telran.utils.annotation.Index;
import telran.utils.annotation.Table;

@Table("employees")
public class Employee {
	@Id
	int id;
	@Index
	String name;
	@Index
	double salary;
	@Index(unique = true)
	String email;
	LocalDate birthDate;

	public Employee() {
	}

	public Employee(int id, String name, double salary, String email, LocalDate birthDate) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.email = email;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee other = (Employee) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", email=" + email + ", birthDate="
				+ birthDate + "]";
	}

}
