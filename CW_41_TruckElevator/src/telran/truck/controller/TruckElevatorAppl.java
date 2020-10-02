package telran.truck.controller;

import telran.truck.model.Elevator;
import telran.truck.model.Truck;

public class TruckElevatorAppl {

	private static final int N_TRUCKS = 1000;
	private static final int N_RACES = 10;
	private static final int CAPACITY = 20;

	public static void main(String[] args) throws InterruptedException {
		Elevator lenin = new Elevator("V. I. Lenin");    //создаем элеватор
		Truck[] trucks = new Truck[N_TRUCKS];           //создаем массив траков - задач
		for (int i = 0; i < trucks.length; i++) {       //создаем массив задач
			trucks[i] = new Truck(N_RACES, CAPACITY, lenin);
		}
		Thread[] threads = new Thread[N_TRUCKS];      //запускаем в цикле задачи
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(trucks[i]);
			threads[i].start();
		}
		for (int i = 0; i < threads.length; i++) {     
			threads[i].join();                         //запускаем join() в цикле (ожидание окончания)
		}

		System.out.println("Elevator " + lenin.getName() + " have " + lenin.getCurrentVolume() + " tonn");

	}

}
