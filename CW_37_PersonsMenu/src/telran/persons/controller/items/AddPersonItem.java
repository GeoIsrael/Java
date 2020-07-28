package telran.persons.controller.items;

import telran.persons.dao.IPersons;
import telran.persons.model.Person;
import telran.view.InputOutput;

public class AddPersonItem extends PersonItem {

	public AddPersonItem(InputOutput inputOutput, IPersons persons) {
		super(inputOutput, persons);
	}

	@Override
	public String displayedName() {
		return "Add person";
	}

	@Override
	public void perform() {
		int id = inputOutput.getInteger("Enter id");
		String name = inputOutput.getString("Enter name");
		Person person = new Person(id, name);
		inputOutput.displayLine(persons.addPerson(person));

	}

}
