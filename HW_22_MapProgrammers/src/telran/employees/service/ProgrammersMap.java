package telran.employees.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import telran.employees.dto.Programmer;

public class ProgrammersMap implements IProgrammers {
	HashMap<Integer, Programmer> programmers;           //HashMap хранилище
	
	public ProgrammersMap() {
		programmers=new HashMap<>();                   //конструктор (создаем HashMap
	}

	@Override
	public boolean addProgrammer(Programmer programmer) {            //добавление программиста (2 способа)
		if (programmer == null) return false;   	  //проверка на корректонсть ввода
//		Programmer prog = programmers.get(programmer.getId());      //метод HashMap
//		if(prog!=null) return false;              //если программист уже есть, возвращаем false, так как он есть
//		programmers.put(programmer.getId(), programmer);       //метод put в коллекциях это альтернатива add в List и Set
//		return true;
		return programmers.putIfAbsent(programmer.getId(), programmer) == null;  //возвращает null если в HashMap отстутствовала пара ключ-значение
	}

	@Override
	public boolean removeProgrammer(int id) {                        //удаление программиста
		return programmers.remove((Integer)id) !=null;
	}

	@Override
	public Programmer getProgrammerData(int id) {                     //возврат объекта программист
		return programmers.get((Integer)id);
	}

	@Override
	public boolean addNewTechnology(int id, String technology) {  //добавление технологии программисту        
		if(technology==null || !programmers.containsKey(id)) return false;         //проверка есть ли такой программист методом containsKey, реверсим если программер есть и возвращаем false, потому что такого программиста нет
		return programmers.get((Integer)id).getTechnologies().add(technology);   //вытаскиваем Set String технологий и добавляем технологию
	}                                                              //проверка на существование технологии нет, потому что коллекция Set без повторяющися элементов

	@Override
	public boolean removeTechnology(int id, String technology) {
		if(technology==null ||!programmers.containsKey(id)) return false;
		return programmers.get((Integer)id).getTechnologies().remove(technology);    // -- remove
	}

	@Override
	public List<Programmer> getProgrammersWithTechnology(String technology) {   //возврат всез программистов с технологией
		List<Programmer> programersWithTechnology = new ArrayList<>();        //создаем ArrayList программистов
		
		for(Programmer prog : programmers.values())             //начинается итерация значений HashMap (перебор всех программистов)
		{
			if(prog.getTechnologies().contains(technology))     //еслли программист владеет технологией
				programersWithTechnology.add(prog);            //добавляем его в List
		} 
		return programersWithTechnology;                       //возвращаем List программистов. которые владеют технологией
	}

	@Override
	public List<Programmer> getProgrammersWithSalary(int salaryFrom, int salaryTo) {     //вернуть лист программистов 
		if(salaryFrom>salaryTo||salaryFrom<0) return null;       // проверка диапазона salary на адекватность
		ArrayList<Programmer> res = new ArrayList<>();           //Создаем новый ArrayList программистов
		for(Programmer programmer : programmers.values())        //итерируем HashMap
		{
			int salary = programmer.getSalary();                 //получаем у каждого объекта salary
			if(salary >= salaryFrom && salary <= salaryTo)       // проверяем salary на вхождение в диапазон
			{
				res.add(programmer);              //если все верно, добавляем объект в ArrayList
			}
		}
		return res;                              //возвращаем List
	}

	@Override
	public boolean updateSalary(int id, int salary) {     //обновление зарплаты
		if(!programmers.containsKey(id)) return false;       //проверка содержится ли такой программист
		Programmer prog = programmers.get((Integer)id);      //получаем программиста
		if(prog.getSalary() != salary )   //если существующая зарплата и переданная не совпадают
		{	
			prog.setSalary(salary);     //устанавливаем новую зп
			return true;                                       //передаем true
		}
		return false;                              //в противном случае передаем false
	}

}
