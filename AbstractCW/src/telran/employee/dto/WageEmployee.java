package telran.employee.dto;

import telran.employee.constants.StateConstants;

public class WageEmployee extends Employee {

	private double wage;

	
	
	
	
	public WageEmployee(int id, String firstName, String lastName, double hours, double wage) {
		super(id, firstName, lastName, hours);
		this.wage = wage;
	}


	
	
	
	
	public double getWage() {
		return wage;
	}


	public void setWage(double wage) {
		this.wage = wage;
	}






	@Override
	public String toString() {
		return "WageEmployee [wage=" + wage + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName()
				+ ", getHours()=" + getHours() + ", getId()=" + getId() + "]";
	}






	@Override
	public double calcSalary() {
	
	double salary =  wage * getHours();
	if (salary < getHours() * StateConstants.MIN_WAGE)       //hours
		return getHours() * StateConstants.MIN_WAGE;
	
	return salary;
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
}
