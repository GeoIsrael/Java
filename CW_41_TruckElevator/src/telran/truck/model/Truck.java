package telran.truck.model;

public class Truck implements Runnable {
	int nRaces;                       //рейсы
	int capacity;						//	вместимость
	Elevator elevator;					//элеватор для выгрузки 
	static Object objectMonitor = new Object();     //статический ObjectMonitor

	public Truck(int nRaces, int capacity, Elevator elevator) {
		this.nRaces = nRaces;
		this.capacity = capacity;
		this.elevator = elevator;
	}

	@Override
	public void run() {
		for (int i = 0; i < nRaces; i++) {
			synchronized (objectMonitor) {     //синхронизировано с монитором
				elevator.add(capacity);
			}
		}

	}

}
