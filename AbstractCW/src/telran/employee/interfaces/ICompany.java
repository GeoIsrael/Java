package telran.employee.interfaces;

import telran.employee.dto.Employee;

public interface ICompany {

	boolean addEmployee(Employee employee);   //добавить эмплоя
	Employee removeEmployee(int id);         
	double totalSalary();             
	double avgSalary();                
	double totalSales();                     
	int size();                             
	void printCompany();                   
	Employee findEmployeeById(int id);
	
	
	
	
	
	
}
