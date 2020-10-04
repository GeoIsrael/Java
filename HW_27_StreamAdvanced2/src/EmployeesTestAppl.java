import java.util.stream.Collectors;
import java.util.*;

public class EmployeesTestAppl {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>(
				Arrays.asList(new Employee(123, "Moshe", "Motorola", 10000), new Employee(124, "Sara", "Nokia", 15000),
						new Employee(125, "David", "Motorola", 20000), new Employee(126, "Asaf", "Nokia", 10000)));
//		displayMinMaxAvgSalary(employees);
//		displayAverageSalary(employees,"Motorola");
//		displayEmployeesAvgSalary(employees);
//		displayBiggestCompanies(employees);                    //распечатка компании с самым большим количеством сотрудников
//		displayCompaniesAboveAvgSalary(employees);             //отображает только компании с средней зарплатой по компании больше чем средняя зарплата глобальная
//		displayShuffledArray(new int[] {1,2,3,4,5,6,7});
//		displayShuffledArray2(new int[] {1,2,3,4,5,6,7});
//		displayEmployeesBySalaryIntervals(employees, 1000);    //показать всех эмплоев по зарплате в нужном интервале
		displayDigitsStatistics();                           //распаковка и подсчет миллион символов                        
	}
	
	
	private static void displayEmployeesBySalaryIntervals(List<Employee> employees, int interval) {
		employees.stream()                               //запускаем стрим эмплоев
		.collect(Collectors.groupingBy(e->e.getSalary()/interval, TreeMap::new, Collectors.toList()))   //14 минута занятие 28: один из вариантов groupingBy - в нее первым параметром передается что попадает в ключи, второй параметр - поставщик supplier что будем делать map, третий параметр коллектор. Сортировку по ключу отдаем в TreeMap
//		.forEach((k,v)-> System.out.printf("[%d - %d) %s\n", k*interval,(k+1)*interval,v));   //Печать будет отрабатывать в виде ссылок, но возвращаются ссылки на объекты
		.forEach((k,v)-> System.out.printf("[%d - %d) %s\n", k*interval,(k+1)*interval,v));   //Печать будет отрабатывать в виде ссылок, но возвращаются ссылки на объекты

	}


	private static void displayDigitsStatistics() {           //метод генирирует миллион цифр от 0 до Integer Max и считает сколько раз цифры встречались во всех этих числах
		new Random().ints(1_000_000, 1, Integer.MAX_VALUE)    //генерируем поток на миллион цифр
		.flatMap(n->Integer.toString(n).chars())              //перегоняем число в строку и разбиваем по символам
		.boxed()                                              //делаем из каждого символа объект (чтобы char превратился в character
		.collect(Collectors.groupingBy(n->n, Collectors.counting()))  //собираем объекты в мепу  ключ сам символ а значение количество символов в числе
		.entrySet().stream()                                   //преобразовываем для сортировки в энтрисет и запускаем поток
		.sorted((e1,e2)->Long.compare(e2.getValue(), e1.getValue()))    //сортируем поток по value (от большего к меньшему в обраном порядке
		.forEach(e->System.out.printf("%c -> %d\n", e.getKey(), e.getValue()));    //распечатываем (%c нужен для представления как символ character
	}
	
	
	
	
	
	
	

	public static void displayMinMaxAvgSalary(List<Employee> employees) {
		IntSummaryStatistics statistics = employees.stream().mapToInt(e -> e.getSalary()).summaryStatistics();
		System.out.printf("min salary=%d,max salary=%d,average salary=%.2f\n", statistics.getMin(), statistics.getMax(),
				statistics.getAverage());
	}

	public static void displayAverageSalary(List<Employee> employees, String company) {
		System.out.printf("average salary for company %s is %.2f\n", company, employees.stream()
				.filter(e -> e.getCompany().equals(company)).mapToInt(e -> e.getSalary()).average().orElse(0));
	}

	public static void displayEmployeesAvgSalary(List<Employee> employees) {
		if (!employees.isEmpty()) {
			double avgSalary = employees.stream().mapToInt(e -> e.getSalary()).average().getAsDouble();
			employees.stream().filter(e -> e.getSalary() > avgSalary).map(e -> new NameSalary(e.name, e.getSalary()))
					.forEach(System.out::println);
		}
	}

//=================================HW===================================================
	public static void displayBiggestCompanies(List<Employee> employees) {
		Map<String, Long> mapCompanies = employees.stream()
				.collect(Collectors.groupingBy(e -> e.getCompany(), Collectors.counting()));    //создаем мепу компаний с количеством сотрудников
		long maxEmployees = mapCompanies.values().stream()               //нужно вычислить компанию с максимальным количеством сотрудников. Запускаем стрим Values
				
//				.mapToLong(v->v)               //Вариант1: преобразуем поток объектов в поток примитивов
//				.max().orElse(0);              //Берем из него максимум, или возвращаем 0, если сотрудников в ккомпании нет
		// =====================
//				.collect(Collectors.maxBy((v1,v2)->Long.compare(v1, v2)))    //Вариант2 : собрать через maxBY метод, принимающий компаратор
//				.orElse(0l);                                                //0l  0 Long
				
				
				.reduce(0l, (max, cur) -> cur > max ? cur : max);            //Варант3: метод reduce (3 варианта реализации) Binary Operator: если если cur>max то верни cur, в противном случае верни max
		//метод reduce = это операции над элементами. идентити это элемент, с которого начнутся все операции, которые происходят в Binary Operators
		
		mapCompanies.forEach((k, v) -> {      //перебираю мепу                                  
			if (v == maxEmployees)            //и если есть компания с максимальным количеством сотрудников
				System.out.println(k);        //распечатываю ее имя
		});
	}

	
	
	public static void displayCompaniesAboveAvgSalary(List<Employee> employees) {
		Map<String, Double> mapCompanies = employees.stream()               //создаем мепу компаний из стрима эмплоев.
				.collect(Collectors.groupingBy(e -> e.getCompany(),        //заходит эмплой - на выходе компани
						Collectors.averagingInt(e -> e.getSalary())));     //коллектор averageInt выуживает из эмплоя зарплату
															//ключ название компании - значение средняя зарплата по компании
		
		
		double avgSalary = employees.stream()     //получаем глобальную среднюю зарплату. запускаем стрим эмплоев
//				.mapToDouble(e->e.getSalary())    //вариант1 
//				.average().orElse(0);
				
				.collect(Collectors.averagingInt(e -> e.getSalary()));   //вариант2 использовать Collectors.averagingInt 
		
		System.out.println("avgSalary = " + avgSalary);     //распечатываем среднюю глобальную зарплату

		mapCompanies.forEach((k,v)->{          //перебираем мепу
			if(v>=avgSalary)                   //если зарплата по компании больше или равна средней
				System.out.println(k);         //распечатываем компанию
		});
	}
	
	public static void displayShuffledArray(int[] ar)
	{
		new Random().ints(0, ar.length).distinct().limit(ar.length)    //в стриме генерация рандомных индексов 
		.forEach(i->System.out.print(ar[i] + " "));                   //и распечатка массива
	}
	
	//Вариант Олега с рандомным компаратором
	public static void displayShuffledArray2(int[] ar) { // Nor my!!!))
        Arrays.stream(ar)
            .boxed()
            .sorted( (a, b) -> new Random().nextInt())
            .forEach(n -> System.out.print(n + " "));
        System.out.println();
        System.out.println(Arrays.toString(ar));
    }

}
