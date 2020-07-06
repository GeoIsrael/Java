package telran.compasssss;

import java.util.Arrays;

public class CompassAppl {

	public static void main(String[] args) {
		
		System.out.println(Compass.NORTH);
		System.out.println(Compass.NORTH.getAssociations());
		System.out.println(Compass.NORTH.name());
		System.out.println(Compass.NORTH.ordinal());              //выводит порядок (индекс)
		Compass south = Compass.valueOf("SOUTH");                 //получает строку - имя элемента перечисления
		System.out.println(south.name());                         //вызывается у класса, а не у объекта
		Compass[] comps=Compass.values();                         //преобразование в массив
		System.out.println(Arrays.toString(comps));
	}

}
