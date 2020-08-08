package telran.employee.dto;

import telran.employee.constants.StateConstants;

public class Manager extends Employee {
	private double baseSalary;
	private int grade;       //позиционный уровень
	
	
	public Manager(int id, String firstName, String lastName, double hours, double baseSalary, int grade) {
		super(id, firstName, lastName, hours);
		this.baseSalary = baseSalary;
		this.grade = grade;
	}


	public double getBaseSalary() {
		return baseSalary;
	}


	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}


	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}


	@Override
	public String toString() {
		return "Manager [baseSalary=" + baseSalary + ", grade=" + grade + ", getFirstName()=" + getFirstName()
				+ ", getLastName()=" + getLastName() + ", getHours()=" + getHours() + ", getId()=" + getId();

	}


	@Override
	public double calcSalary() {
		double salary = baseSalary * grade; 					//зарплата это базовая зарплата * позицинный уровень
		if (salary < getHours() * StateConstants.MIN_WAGE)     //вычисляем зарплату
			salary = getHours() * StateConstants.MIN_WAGE;
		return salary;
	}

	
	
	
	
	
	
	
	
	
	
}
