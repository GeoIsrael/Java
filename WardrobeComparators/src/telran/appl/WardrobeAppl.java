package telran.appl;

import java.util.Arrays;
import java.util.Comparator;

import telran.comparators.ComparatorByHight;
import telran.comparators.VolumeComparator;
import telran.impl.Wardrobe;

public class WardrobeAppl {

	public static void main(String[] args) {
		
		Wardrobe[] wardrobes = new Wardrobe[20];
		fillArray(wardrobes);
		printArray(wardrobes);
//		Comparator<Wardrobe> comp = new VolumeComparator();
		Comparator<Wardrobe> comp = new ComparatorByHight();

		Arrays.sort(wardrobes, comp);
		printArray(wardrobes);

		
	}

	private static void printArray(Wardrobe[] wardrobes) {

		for (Wardrobe wardrobe : wardrobes) {		
			System.out.println(wardrobe);
		}
		System.out.println("***************************************");
	
		
	}

	private static void fillArray(Wardrobe[] wardrobes) {
		for (int i = 0; i < wardrobes.length; i++) {
			wardrobes[i] = getRandomWardrobe();
		}
		
	}

	private static Wardrobe getRandomWardrobe() {
		double width = Math.random()*10;
		double length = Math.random()*10;
		double heigth = Math.random()*10;
		return new Wardrobe(width, length, heigth);
	}

}
