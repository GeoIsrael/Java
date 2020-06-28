package telran.employees.dto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Programmer {
	int id;
	String name;
	int salary;
	Set<String> technologies;
	
	public Programmer() {
		technologies=new HashSet<String>();
	}

	public Programmer(int id, String name, int salary, String[] technologies) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.technologies = new HashSet<String>(Arrays.asList(technologies));
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<String> getTechnologies() {
		return technologies;
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Programmer other = (Programmer) obj;
		if (id != other.id)
			return false;
		return true;
	}	

}
