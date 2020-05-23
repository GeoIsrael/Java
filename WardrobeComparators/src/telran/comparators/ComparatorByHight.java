package telran.comparators;

import java.util.Comparator;

import telran.impl.Wardrobe;

public class ComparatorByHight implements Comparator<Wardrobe> {

	@Override
	public int compare(Wardrobe o1, Wardrobe o2) {
		return Double.compare(o1.getHeigth(), o2.getHeigth());
	}



}
