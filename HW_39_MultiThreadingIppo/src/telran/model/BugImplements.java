package telran.model;

import java.util.concurrent.ThreadLocalRandom;

import telran.controller.IppodromeApps;


public class BugImplements implements Runnable  {

	String name;                                         //Имя жука
    int distance;                                        //Дистанция забега
	int rating = 0;                                          //победитель или нет?



	public BugImplements(String name, int distance) {                    //Конструктор жука
		this.name = name;
		this. distance = distance;
		
	}
	
	public String getName() {
		return name;
	}

	public int getRating() {
		return rating;
	}
 

	    
	
	
	
	@Override
	public void run() {

		System.out.println(name + " i start, boss");                  //старт
		int pause;                                          
		for (int i = 0; i < distance; i++) {               //в цикле
			pause = ThreadLocalRandom.current().nextInt(2, 6);             //генерируем паузу
			rating += pause;                  //прибавляем ее к общей паузе
			System.out.println(name + " перерыв номер: " + i + "длительность" + pause);
			
			try {
				Thread.sleep(pause);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		   
		}
		if (IppodromeApps.winner == null) {                      //занимаем ячейку победителя своим именем
			IppodromeApps.winner = name;
		}
		System.out.println(name + " finished, my time is: " + rating);
		

		IppodromeApps.ratingMap.put(name, rating);
		
	}

	
	







	

}
