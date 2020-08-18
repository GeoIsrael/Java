package telran.truck.model;

public class Elevator {
	String name;
	int currentVolume;

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
			currentVolume += portion;
	}

}
