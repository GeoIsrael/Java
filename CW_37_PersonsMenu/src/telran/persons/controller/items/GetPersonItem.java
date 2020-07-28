package telran.persons.controller.items;

import telran.persons.dao.IPersons;
import telran.persons.model.Person;
import telran.view.InputOutput;

public class GetPersonItem extends PersonItem {

	public GetPersonItem(InputOutput inputOutput, IPersons persons) {
		super(inputOutput, persons);
	}

	@Override
	public String displayedName() {
		return "Find person by id";
	}

	@Override
	public void perform() {
		int id = inputOutput.getInteger("Enter id");
		Person person = persons.getPerson(id);
		inputOutput.displayLine(person != null ? person : "Person not found");

	}

}
