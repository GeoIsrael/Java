package telran.person.controller;

import telran.person.model.Employee;
import telran.utils.service.TableInfoRunner;

public class PersonAppl {

	public static void main(String[] args) {
		TableInfoRunner.runInfo(Employee.class);

	}

}
