package telran.employees.dto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Programmer {                
	int id;             
	String name;
	int salary;
	Set<String> technologies;     //список технологий программиста (Сэт стрингов)
	
	public Programmer() {
	    technologies = new HashSet<String>();    //HashSet может быть не создан в пустом конструкторе, нужно создать его в ручную
	}          //пустой конструктор

	public Programmer(int id, String name, int salary, String[] technologies) {       //конструктор с полями 
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.technologies = new HashSet<String>(Arrays.asList(technologies));    //в сет помещается массив стрингов 
		                                                                         
	}

	public int getSalary() {                    //вернуть зп
		return salary;
	}

	public void setSalary(int salary) {         //установить зп
		this.salary = salary;
	}

	public int getId() {                       //вернуть id
		return id;
	}

	public String getName() {                  //вернуть name
		return name;
	}

	public Set<String> getTechnologies() {        //вернуть технологиии
		return technologies;
	}

	@Override
	public int hashCode() {                      //   hash - equals
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
		Programmer other = (Programmer) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
	
	

}
