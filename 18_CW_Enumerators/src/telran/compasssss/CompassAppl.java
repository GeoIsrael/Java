package telran.compasssss;

import java.util.Arrays;

public class CompassAppl {

	public static void main(String[] args) {
		
		System.out.println(Compass.NORTH);
		System.out.println(Compass.NORTH.getAssociations());
		System.out.println(Compass.NORTH.name());
		System.out.println(Compass.NORTH.ordinal());
		Compass south = Compass.valueOf("SOUTH");
		System.out.println(south.name());
		Compass[] comps=Compass.values();
		System.out.println(Arrays.toString(comps));
	}

}
