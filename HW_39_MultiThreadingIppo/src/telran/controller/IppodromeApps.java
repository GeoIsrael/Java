package telran.controller;
 
import java.util.Map;
import java.util.TreeMap;
import java.util.Collections;

import telran.model.BugImplements;

public class IppodromeApps {

	private static final int DISTANCE = 10;    //константа для создания циклов в классах потоков
	private static final int SIZE = 10;    //сколько будет потоков в массиве
//    public static Map <String, Integer> ratingMap = Collections.synchronizedMap(new TreeMap<>());    //доска почета

	public static Map <String, Integer> ratingMap = Collections.synchronizedMap(new TreeMap<>());    //Синхронизированная обертка для TreeMap 

    public static String winner = null;
    
	public static void main(String[] args) throws InterruptedException {
		   
		
		BugImplements[] taskBugs = new BugImplements[SIZE];  //создаем массив задач для жуков
		for (int i = 0; i < taskBugs.length; i++) {          
			taskBugs[i] = new BugImplements("Bug#" + i, DISTANCE);    //в цикле наполняем массив задачами в цикле
		}
		Thread[] bugs = new Thread[SIZE];               //в цикле делаем из массива задач массив потоков
		for (int i = 0; i < bugs.length; i++) {
			bugs[i] = new Thread(taskBugs[i]);
		}
		
		System.out.println("Go, Bugs!!!");                 //запускаем жуков
		for (int i = 0; i < bugs.length; i++) {         //в цикле запускаем потоки из массива
			bugs[i].start();
		}

		for (int i = 0; i < bugs.length; i++) {           //расстановка оиданий всех потоков в цикле
			bugs[i].join();
		}
		System.out.println("Bugs finished");    //финиш

		
		
		System.out.println("Всего участников: " + ratingMap.size());
//        ratingMap.forEach((k, v) -> System.out.print((k + ":" + v)+ " "));      //Stream Treemap
      ratingMap.entrySet().stream()
      	.sorted(Map.Entry.<String, Integer>comparingByValue()) 
     
      	.forEach(System.out::println);      //доска почета
		System.out.println("\n======================");

	   System.out.println("поздравляем победителя участника " + winner);
	}

}
