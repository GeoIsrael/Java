package telran.truck.model;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Elevator {
	String name;
	int currentVolume;
	Lock lock = new ReentrantLock();

	public Elevator(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCurrentVolume() {
		return currentVolume;

	}

	public void add(int portion) {
		try {
			lock.lock();
			currentVolume += portion;
		} finally {
			lock.unlock();
		}

	}

}
