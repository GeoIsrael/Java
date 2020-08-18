package telran.car.controller;

import telran.car.model.Car;
import telran.utils.service.TableInfoRunner;

public class CarAppl {

	public static void main(String[] args) {
		Car car = new Car();
		TableInfoRunner.runInfo(car);

	}

}
