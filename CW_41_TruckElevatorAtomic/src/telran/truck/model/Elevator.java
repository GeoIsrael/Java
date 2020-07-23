package telran.truck.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Elevator {
	String name;
	AtomicInteger currentVolume;

	public Elevator(String name) {
		this.name = name;
		currentVolume = new AtomicInteger(0);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCurrentVolume() {
			return currentVolume.get();
		
	}

	public void add(int portion) {
			currentVolume.addAndGet(portion);
	}

}
