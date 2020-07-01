import java.util.IntSummaryStatistics;
import java.util.*;

public class EmployeesTestAppl {

	public static void main(String[] args) {
		List<Employee> employees=new ArrayList<>(    
				Arrays.asList(
						new Employee(123, "Moshe", "Motorola", 10000),
						new Employee(124, "Sara", "Nokia", 15000),
						new Employee(125, "David", "Motorola", 20000),
						new Employee(126, "Asaf", "Nokia", 10000)));
		
		
		displayMinMaxAvgSalary(employees);            //вернуть минимальную, максимальную и среднюю зарплату у всех эмплоев
		displayAverageSalary(employees,"Motorola"); //вернуть среднюю зарплату в компании которая указана
		displayEmployeesAvgSalary(employees);     //показать имя и зарплату сотрудников, чья зарплата выше чем средняя зарплата

	}
	public static void  displayMinMaxAvgSalary(List<Employee>employees) {
		IntSummaryStatistics statistics=employees.stream()           //IntSummaryStatistics класс с набором методов для вычислений
				.mapToInt(e->e.salary).summaryStatistics();        //запускаем стрим объектов. делаем перевод в стрим примитивов зарплат. к стриму примитивов применяем метод SummaryStatistic()
		//который возвращает объект IntSummaryStatistics, внутри которого есть вычесления getMin, getMax и среднее
		System.out.printf
		("min salary=%d,max salary=%d,average salary=%.2f\n",               //выводим данные на консоль
				statistics.getMin(),statistics.getMax(),statistics.getAverage());
	}

	public static void displayAverageSalary(List<Employee> employees,String company) {   //средняя зарплата по компании
		System.out.printf("average salary for company %s is %.2f\n",
				company,employees.stream().      //запускаю стрим
				filter(e->e.company.equals(company))   //фильтрую по нужной компании
				.mapToInt(e->e.salary).average().orElse(0));    //делаю стрим примитивов зарплат. вычисляю среднее иил возвращаю 0
	}                                                           //average возвращает объект Optional double (который никогда не будет null

	public static void displayEmployeesAvgSalary(List<Employee> employees) {
		if (!employees.isEmpty()) {                  //проверка для того чтобы использовать метод getAsDouble, или заменить на orElse(0) в конце стрима
			double avgSalary = employees.stream()    //вычисление средней зарплаты среди всех сотрудников 
					.mapToInt(e -> e.salary)
					.average().getAsDouble();            //getAsDouble возвращает double
			employees.stream()
			.filter(e -> e.salary > avgSalary)
			.map(e -> new NameSalary(e.name, e.salary)) 
					.forEach(System.out::println);          //распечатываем стрим 
		}		
	}


}
