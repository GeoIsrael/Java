public class Employee {
public int id;
public String name;
private String company;
private int salary;

public Employee(int id, String name, String company, int salary) {
	this.id = id;
	this.name = name;
	this.company = company;
	this.salary = salary;
}

public int getSalary() {
	return salary;
}

public void setSalary(int salary) {
	this.salary = salary;
}

public String getCompany() {
	return company;
}

public void setCompany(String company) {
	this.company = company;
}


}
