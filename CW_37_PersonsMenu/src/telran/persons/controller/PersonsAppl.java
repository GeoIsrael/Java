package telran.persons.controller;

import telran.persons.controller.items.AddPersonItem;
import telran.persons.controller.items.DisplayAllPersonsItem;
import telran.persons.controller.items.GetPersonItem;
import telran.persons.dao.IPersons;
import telran.persons.dao.PersonMap;
import telran.view.ConsoleInputOutput;
import telran.view.InputOutput;
import telran.view.Item;
import telran.view.Menu;
import telran.view.MenuWithExit;

public class PersonsAppl {

	public static void main(String[] args) {
		InputOutput inputOutput = new ConsoleInputOutput();    //смотреть в меню класс
		IPersons persons = new PersonMap();
		Item[] items = {
				new AddPersonItem(inputOutput, persons),
				new GetPersonItem(inputOutput, persons),
				new DisplayAllPersonsItem(inputOutput, persons)
		};
		Menu menu = new MenuWithExit(inputOutput, items);
		menu.runMenu();

	}

}
