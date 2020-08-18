package telran.car.model;

import telran.utils.annotation.Id;
import telran.utils.annotation.Index;
import telran.utils.annotation.Table;

@Table("cars")
public class Car {
	@Id
	String regNumber;
	@Index(unique = true)
	String model;
	@Index
	double engine;
	@Index
	double gazTank;

	public Car() {
	}

	public Car(String regNumber, String model, double engine, double gazTank) {
		this.regNumber = regNumber;
		this.model = model;
		this.engine = engine;
		this.gazTank = gazTank;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public String getModel() {
		return model;
	}

	public double getEngine() {
		return engine;
	}

	public double getGazTank() {
		return gazTank;
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
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Car)) {
			return false;
		}
		Car other = (Car) obj;
		if (regNumber == null) {
			if (other.regNumber != null) {
				return false;
			}
		} else if (!regNumber.equals(other.regNumber)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Car [regNumber=" + regNumber + ", model=" + model + ", engine=" + engine + ", gazTank=" + gazTank + "]";
	}

}
