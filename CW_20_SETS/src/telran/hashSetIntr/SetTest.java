package telran.hashSetIntr;


import java.util.LinkedHashSet;

public class SetTest {

	public static void main(String[] args) {
	//	HashSet<Cat> cats = new HashSet<Cat>();                     //HashSet          (порядок случайный)
		LinkedHashSet<Cat> cats = new LinkedHashSet<Cat>();         //LinkedHashSet    (порядок закономерный)
		Cat vasya = new Cat("Vasya", 5, 'M');
		Cat barsik = new Cat("Barsik", 4, 'M');
		Cat diana = new Cat("Diana", 8, 'F');
		Cat masha = new Cat("Masha", 6, 'F');
		Cat vasya2 = new Cat("Vasya", 5, 'M');
		
		System.out.println(cats.add(vasya));
		cats.add(barsik);
		cats.add(diana);
		cats.add(masha);
		System.out.println(cats.add(vasya2));
		System.out.println(cats.size());
		System.out.println(cats);
		
//		for(int i = 0; i<cats.size();i++)
//		{
//			System.out.println(cats[i]);
//		}
		
		for(Cat cat: cats)
		{
			System.out.println(cat);
		}
		
		System.out.println("===============================================");
		Object[] catArr = cats.toArray();
		for(int i=0;i<catArr.length;i++)
		{
			System.out.println(catArr[i]);
		}
		
		cats.remove(diana);
		System.out.println(cats);
		
	}

}
