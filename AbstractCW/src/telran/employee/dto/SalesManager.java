package telran.employee.dto;

import telran.employee.constants.StateConstants;

public class SalesManager extends Employee {
	
	private double salesValue;
	private double percent;
	
	
	
	public SalesManager(int id, String firstName, String lastName, double hours, double salesValue, double percent) {
		super(id, firstName, lastName, hours);
		this.salesValue = salesValue;
		this.percent = percent;
	}
	
	
	
	public double getSalesValue() {
		return salesValue;
	}
	public void setSalesValue(double salesValue) {
		this.salesValue = salesValue;
	}
	public double getPercent() {
		return percent;
	}
	public void setPercent(double percent) {
		this.percent = percent;
	}



	@Override
	public String toString() {
		return "SalesManager [salesValue=" + salesValue + ", percent=" + percent + ", getFirstName()=" + getFirstName()
				+ ", getLastName()=" + getLastName() + ", getHours()=" + getHours() + ", getId()=" + getId() + "]";
	}



	@Override
	public double calcSalary() {

		double salary = salesValue*percent/100;
		if (salary < getHours() * StateConstants.MIN_WAGE)       //hours
			return getHours() * StateConstants.MIN_WAGE;
		
		return salary;
	}

	
	
	
	
	
	
	

}
