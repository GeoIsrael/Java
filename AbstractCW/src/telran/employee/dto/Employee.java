package telran.employee.dto;

public abstract class Employee {

	
	
	private int id;
	private String firstName;
	private String lastName;
	private double hours;
	
	
	
	
	public Employee(int id, String firstName, String lastName, double hours) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.hours = hours;
	}
	

	
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getHours() {
		return hours;
	}
	public void setHours(double hours) {
		this.hours = hours;
	}
	public int getId() {
		return id;
	}

		
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", hours=" + hours + "]";
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
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	//-------------------
	
	abstract public double calcSalary();
	
	
	
	
	
	
}
