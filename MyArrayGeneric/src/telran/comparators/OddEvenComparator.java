package telran.comparators;

import java.util.Comparator;

public class OddEvenComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {

		if (o1 % 2 == 0 && o2 % 2 != 0) return -1;
		
		if (o1 % 2 != 0 && o2 % 2 == 0) return 1;
		
		if (o1 % 2 == 0 && o2 % 2 == 0) return o1 - o2;          //сортировка в порядке возрастания
		
		if (o1 % 2 != 0 && o2 % 2 != 0) return o2 - o1;          //сортировка в порядке убывания
		
		return 0;
	}

}
