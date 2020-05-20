package telran.penquin;

import java.util.Comparator;

public class ComparatorByWeight implements Comparator<Penguin> {

	@Override
	public int compare(Penguin p1, Penguin p2) {

		float res1 = p1.getWeight();
		float res2 = p2.getWeight();
		if (res1 > res2) return 1;
		else if (res1 < res2) return -1;
		return 0;
		
//		return Float.compare(res1, res2);      //альтернативный вариант с классом оберткой
		
	}

}
