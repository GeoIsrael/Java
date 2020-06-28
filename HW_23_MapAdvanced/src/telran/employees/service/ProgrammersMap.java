package telran.employees.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import telran.employees.dto.Programmer;

public class ProgrammersMap implements IProgrammers {
	HashMap<Integer, Programmer> programmers;
	HashMap<String,List<Programmer>> techProgrammers=new HashMap<>();     //добавили 2 карты 
	TreeMap<Integer,List<Programmer>> salaryProgrammers=new TreeMap<>();

	public ProgrammersMap() {                               
		programmers = new HashMap<>();
	}

	@Override
	public boolean addProgrammer(Programmer programmer) {           //основное хранилище - остальные две карты зависимые
		if (programmer == null)                              //проверка
			return false;
		boolean res = programmers.putIfAbsent(programmer.getId(), programmer) == null;  //вставка программера в основную карту с сохранением результата метода
		if (res) {        //если всв в порядке
			addTechProgrammers(programmer);      //вставляем в две других карты 
			addSalaryProgrammers(programmer);      
		}
		return res;             //возвращаю результат вставки основного метода
	}

	private void addSalaryProgrammers(Programmer programmer) {        //добавление в карту 1  (программист уже проверен что не null
		int salary = programmer.getSalary();          //получаю зарплату программиста
		List<Programmer> programmersList = salaryProgrammers.getOrDefault(salary, new ArrayList<>());  //возвращаю список программистов через getOrDefult или пустой лист 
		programmersList.add(programmer);   //добавляю в вернувшийся лист программиста
		salaryProgrammers.putIfAbsent(salary, programmersList);    //добавь если пары ключ значение не было, если б была то добавления не происходит. нужно только если пары ключ значение у salary не было

	}

	private void addTechProgrammers(Programmer programmer) {           //добавление в карту 2
		for (String technology : programmer.getTechnologies())         //перебор в цикле у программера технологии
			addTechnologyMap(technology, programmer);                  //и вызов метода добавление технологии (акцент на дробление в угоду читаемости)

	}
	
	private void addTechnologyMap(String technology, Programmer programmer) {  //по аналогии добавления в предыдущую мапу, только с циклом
		List<Programmer>programmersList=
				techProgrammers.getOrDefault(technology,new ArrayList<>());
		programmersList.add(programmer);
		techProgrammers.putIfAbsent(technology, programmersList);
		
	}

	@Override
	public boolean removeProgrammer(int id) {                   //удаляю программиста
		Programmer programmer=programmers.remove(id);      //метод remove как правило возвращает объект, который он удалил. Это нужно чтобы удалить объект из других связанных структур        
		boolean res= programmer!=null; //и если объект не null, то есть что то было удалено, то res станет true (флаг)
	if(res) {                 //если он true 
		removeFromTechProgrammers(programmer);       //удаляем из двух других map:
		removeFromSalaryProgrammers(programmer);
	}
		return res;               
	}
	
	private void removeFromSalaryProgrammers(Programmer programmer) {
		salaryProgrammers.get(programmer.getSalary()).remove(programmer);      //последовательность - getSalary -> get  -> remove
		
	}

	private void removeFromTechProgrammers(Programmer programmer) {
		for(String technology:programmer.getTechnologies()) {           //через цикл запрашивать сет технологий 
			removeTechMap(technology,programmer);                     //и отправлять на метод удаления технологий
		}
		
	}

	private void removeTechMap(String technology, Programmer programmer) {         
		techProgrammers.get(technology).remove(programmer);          //возвращаю список программистов по технологиямм и вызываю метод remove
		
	}

	@Override
	public Programmer getProgrammerData(int id) {              //
		return programmers.get((Integer) id);              
	}

	@Override
	public boolean addNewTechnology(int id, String technology) {       
		if (technology == null)                         //проверка
			return false;
		Programmer programmer=programmers.get(id);      
		boolean res=programmer!=null;
		if(res) {
			programmer.getTechnologies().add(technology);    //вызываю у программиста сет технологий и добавляю туда технологию
			addTechnologyMap(technology,programmer);        //добавь программиста в мапу технологий
		}
		return res;
	}

	@Override
	public boolean removeTechnology(int id, String technology) {        // по аналогии с добавлением все
		if (technology == null)
			return false;
		Programmer programmer=programmers.get(id);
		boolean res=programmer!=null;
		if(res) {
			programmer.getTechnologies().remove(technology);
			removeTechnologyMap(technology,programmer);
		}
		return res;
	}
	
	private void removeTechnologyMap(String technology, Programmer programmer) {
		techProgrammers.get(technology).remove(programmer);
		
	}

	@Override
	public List<Programmer> getProgrammersWithTechnology(String technology) {
//		List<Programmer> programersWithTechnology = new ArrayList<>();
//
//		for (Programmer prog : programmers.values()) {
//			if (prog.getTechnologies().contains(technology))
//				programersWithTechnology.add(prog);
//		}
//		return programersWithTechnology;
		return techProgrammers.getOrDefault(technology,        //сейчас код упростился из за налиия метода techProgremmers
				new ArrayList<>());
	}

	@Override
	public List<Programmer> getProgrammersWithSalary(int salaryFrom, int salaryTo) {
		if (salaryFrom > salaryTo || salaryFrom < 0)                  //проверка на адекватность значений 
			return null;
//		ArrayList<Programmer> res = new ArrayList<>();
//		for (Programmer programmer : programmers.values()) {
//			int salary = programmer.getSalary();
//			if (salary >= salaryFrom && salary <= salaryTo) {
//				res.add(programmer);
//			}
//		}
//		return res;
		List<Programmer>res=new ArrayList<>();       //создаем новый лист программистов
		Collection<List<Programmer>>lists=     //создаем коллекцию листов программистов 
				salaryProgrammers.subMap(salaryFrom,salaryTo).values();   //возвращает из Map коллекцию values
		if (lists!=null) {         //если она не равна нулю
			for (List<Programmer> list : lists) {   //берем по одному 
				res.addAll(list);                //метод добавляет все значения из каждого листа
			} 
		}
		return res;             //возврат результирующего массива
	}

	@Override
	public boolean updateSalary(int id, int salary) {      //апдейт селари
		Programmer programmer=programmers.get(id);         //запрос программиста по айди
		if (programmer==null||programmer.getSalary() == salary)   //если он отсутствует или его текущая зарплата = переданной, то отказ
			return false;
		removeFromSalaryProgrammers(programmer);    // вызываю три метода для разных подструктур    
		programmer.setSalary(salary);
		addSalaryProgrammers(programmer);
		return true;
	}

}
// 
