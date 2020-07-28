package telran.persons.controller.items;

import telran.persons.dao.IPersons;
import telran.view.InputOutput;

public class DisplayAllPersonsItem extends PersonItem {

	public DisplayAllPersonsItem(InputOutput inputOutput, IPersons persons) {
		super(inputOutput, persons);
	}

	@Override
	public String displayedName() {
		return "Display all persons";
	}

	@Override
	public void perform() {
		persons.getAllPersons().forEach(inputOutput::displayLine);
	}

}
