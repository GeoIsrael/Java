import java.util.Comparator;

public class CatsComparatorByAge implements Comparator<Cat> {

	@Override
	public int compare(Cat o1, Cat o2) {
	
		return o1.getAge()-o2.getAge();
	}

}
