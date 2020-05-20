package telran.penquin;

import java.util.Comparator;

public class ComparatorByNameReverse implements Comparator<Penguin> {

	@Override
	public int compare(Penguin p1, Penguin p2) {

		return p2.getName().compareTo(p1.getName());
	}

}
