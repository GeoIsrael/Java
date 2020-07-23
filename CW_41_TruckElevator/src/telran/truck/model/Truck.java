package telran.truck.model;

public class Truck implements Runnable {
	int nRaces;
	int capacity;
	Elevator elevator;
	static Object objectMonitor = new Object();

	public Truck(int nRaces, int capacity, Elevator elevator) {
		this.nRaces = nRaces;
		this.capacity = capacity;
		this.elevator = elevator;
	}

	@Override
	public void run() {
		for (int i = 0; i < nRaces; i++) {
			synchronized (objectMonitor) {
				elevator.add(capacity);
			}
		}

	}

}
