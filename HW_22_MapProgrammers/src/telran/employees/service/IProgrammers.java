package telran.employees.service;

import java.util.List;

import telran.employees.dto.Programmer;

public interface IProgrammers {
	boolean addProgrammer(Programmer programmer);            //добавить программиста
	boolean removeProgrammer(int id);                        //удалить программиста
	Programmer getProgrammerData(int id);                    //вернуть программиста как объект 
	boolean addNewTechnology(int id, String technology);        //добавить программисту новую технологию
    boolean removeTechnology(int id,String technology);            //удалить новую технологию у программиста
    List<Programmer> getProgrammersWithTechnology(String technology);      //вернуть спискок технологий программистов, знающих технологию
    List<Programmer> getProgrammersWithSalary(int salaryFrom, int salaryTo);   //вернуть список программистов с вилкой зарплат
    boolean updateSalary(int id, int salary);              //обновить зарплату у программиста
	
}
