package telran.dto;

public class Employee {
	
	private long id;
	private int salary;
	private String department;
	private String title;
	private String name;
	
	public Employee(long id, int salary, String department, String title, String name) {
		super();
		this.id = id;
		this.salary = salary;
		this.department = department;
		this.title = title;
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", salary=" + salary + ", department=" + department + ", title=" + title
				+ ", name=" + name + "]";
	}


	
	
	
}
