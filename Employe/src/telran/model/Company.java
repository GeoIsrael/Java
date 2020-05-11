package telran.model;

import java.util.Arrays;

import telran.dto.Employee;

public class Company {
	Employee[] employees = new Employee[0];
	int index = -1;
	
	public boolean hire(Employee emp) {
		if (getEmployee(emp.getId()) != null) return false;
		employees = Arrays.copyOf(employees, employees.length + 1);
		employees[employees.length - 1] = emp;               //индекс последней ячейки
		return true;
		
	}

	public Employee getEmployee(long id) {
		for (int i=0;i<employees.length;i++) {
			if (employees[i].getId()==id) {
//				index = i;
				return employees[i];
			}
		}	
		return null;
	}
	
	
// classwork version	
//	
//	boolean fire(long id) {
//		if (getEmployee(id)==null) return false;
//		
//		for (int i = index; i < employees.length - 1; i++  ) {
//			employees[i] = employees[i+1];
//		}
//		employees = Arrays.copyOf(employees, employees.length - 1);
//		return true;
//	}
	
	
//my version
	boolean fire(long id) {
		if (getEmployee(id)==null) return false;		
		employees[index] = employees[employees.length - 1];         
		employees = Arrays.copyOf(employees, employees.length - 1); 
		return true;
	}
	
	
	

}
