package telran.employee.model;

import telran.employee.dto.Employee;
import telran.employee.dto.SalesManager;
import telran.employee.interfaces.ICompany;

public class Company implements ICompany {
	private Employee[] employees;
	private int size;
	private String name;
	
	
	public Company(String nameCompany, int capacity) {
		name = nameCompany;
		employees = new Employee[capacity];
		size = 0;
		

	}


	@Override
	public boolean addEmployee(Employee employee) {
		if (size==employees.length||findEmployeeById(employee.getId())!=null) return false;  //
		
		employees[size++] = employee;
		
		return true; 
	}
		


	@Override
	public Employee removeEmployee(int id) {
		for (int i = 0; i < size; i++) {
			if (employees[i].getId() == id) {
				Employee temp = employees[i];
				employees[i] = employees[--size];
				employees[size] = null;
				return temp;		
			}
		}
		return null;
	}

	

	@Override
	public double totalSalary() {
		double sum = 0;
		for (int i = 0; i < size; i ++) {
			sum += employees[i].calcSalary();
		}
			
		return sum;
	}


	@Override
	public double avgSalary() {
		return totalSalary()/size;
	}


	@Override
	public double totalSales() {
		double sum = 0;
		for (int i =0; i < size; i++) {
			if (employees[i] instanceof SalesManager) {
				SalesManager sm = (SalesManager) employees[i];
				sum += sm.getSalesValue();
			}
		}	
		return sum;
	}	
	

	@Override
	public int size() {
		return size;
	}


	@Override
	public void printCompany() {
		System.out.println("Company name:" + name);
		for (int i = 0; i < size; i ++) {
			System.out.println(employees[i]);
		}
	}


	@Override
	public Employee findEmployeeById(int id) {

		for (int i = 0; i < size; i++) {
			if (employees[i].getId() == id) {
				return employees[i];
			}
		}
		return null;
	}
	
	
	
	
	
	
	
	
	

}
