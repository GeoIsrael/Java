package telran.view;

public class Menu {
	private InputOutput inputOutput;
	protected Item[] items;

	public Menu(InputOutput inputOutput, Item[] items) {
		this.inputOutput = inputOutput;
		this.items = items;
	}

	public void runMenu() {
		int iNumber = 0;
		do {
			for (int i = 1; i <= items.length; i++) {
				inputOutput.displayLine(i + "." + items[i - 1].displayedName());
			}
			iNumber = inputOutput.getInteger("Enter item's number",
					1, items.length);
			items[iNumber - 1].perform();
		} while (!items[iNumber - 1].isExit());
	}

}
