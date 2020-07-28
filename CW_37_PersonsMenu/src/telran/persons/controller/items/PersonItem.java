package telran.persons.controller.items;

import telran.persons.dao.IPersons;
import telran.view.InputOutput;
import telran.view.Item;

public abstract class PersonItem extends Item {
		protected IPersons persons;

		public PersonItem(InputOutput inputOutput, IPersons persons) {
			super(inputOutput);
			this.persons = persons;
		}

}
