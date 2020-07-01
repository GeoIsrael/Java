package telran.cats;

public class CatsTest {

	public static void main(String[] args) {
		
		Cat current = Cat.MURKA;
		Cat current2 = Cat.BARSIK;
		System.out.println(current);
		
		displayCat(Cat.FIONA);
	}

	private static void displayCat(Cat cat) {
		switch (cat) {
		case VASYA:
			System.out.println("Cat Vasily");
			break;
		case MURZIK:
			System.out.println("Cat Murzily");
			break;
		case DIANA:
			System.out.println("Pussycat Dianisiy");
			break;
		case MURKA:
			System.out.println("Pussycat Murkusya");
			break;
		case FIONA:
			System.out.println("Pussycat Fiona");
			break;
		case BARSIK:
			System.out.println("Cat Barsily");
			break;
		default:
			System.out.println("Unknow cat");
		}
		
	}

}
