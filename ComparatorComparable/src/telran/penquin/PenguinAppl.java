package telran.penquin;

import java.util.Arrays;

public class PenguinAppl {

	public static void main(String[] args) {

		Penguin[] penguins = {
				new Penguin(5.f, 5000, "Ubuntu"),
				new Penguin(30.f, 10000, "Kali"),
				new Penguin(59.f, 40000, "Arch"),
				new Penguin(23.f, 10000, "Mint")
		};
		
		printPenguins(penguins);
		Arrays.sort(penguins, new ComparatorByPrice());
		printPenguins(penguins);
		Arrays.sort(penguins, new ComparatorByName());
		printPenguins(penguins);
		Arrays.sort(penguins, new ComparatorByWeight());
		printPenguins(penguins);
		Arrays.sort(penguins, new ComparatorByNameReverse());
		printPenguins(penguins);
		

		
	}

	private static void printPenguins(Penguin[] penguins) {
		for (Penguin x: penguins) {
			System.out.println(x);
		}
		System.out.println("********************************************");
	}

}
