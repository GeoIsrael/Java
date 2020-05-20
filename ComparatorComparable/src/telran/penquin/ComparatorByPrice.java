package telran.penquin;

import java.util.Comparator;

public class ComparatorByPrice implements Comparator<Penguin> {

	@Override
	public int compare(Penguin p1, Penguin p2) {
		
		return p1.getPrice()-p2.getPrice();
	}

}
