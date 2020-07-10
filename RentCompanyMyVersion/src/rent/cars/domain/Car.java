package rent.cars.domain;

import rent.cars.dto.State;

public class Car {

	private String regNumber;        //номер регистрации автомобиля
	private String color;            //цвет
	private State state;             //состояние автомобиля
	private String modelName;        //наименование модели
	private boolean inUse;    		 //флаг использования
	private boolean flRemoved;       //флаг удаления

	public Car() {}

	public Car(String regNumber, String color, String modelName) {
		this.regNumber = regNumber;
		this.color = color;
		this.modelName = modelName;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public boolean isInUse() {
		return inUse;
	}

	public void setInUse(boolean inUse) {
		this.inUse = inUse;
	}

	public boolean isFlRemoved() {
		return flRemoved;
	}

	public void setFlRemoved(boolean flRemoved) {
		this.flRemoved = flRemoved;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public String getColor() {
		return color;
	}

	public String getModelName() {
		return modelName;
	}

	@Override
	public String toString() {
		return "Car [regNumber=" + regNumber + ", color=" + color + ", modelName=" + modelName + ", inUse=" + inUse
				+ ", flRemoved=" + flRemoved + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((regNumber == null) ? 0 : regNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (regNumber == null) {
			if (other.regNumber != null)
				return false;
		} else if (!regNumber.equals(other.regNumber))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
}
