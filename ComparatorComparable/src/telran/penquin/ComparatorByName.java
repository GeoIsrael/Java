package telran.penquin;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Penguin> {

	@Override
	public int compare(Penguin p1, Penguin p2) {
		
		return p1.getName().compareTo(p2.getName());
	}

}
