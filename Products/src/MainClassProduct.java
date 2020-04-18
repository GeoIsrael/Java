//1) Напишите класс Product с полями:
// private String name; Наименование
// private double price; цена
// private String mItem; тип тары, например:box 1kg или Pack 1 Litre
// private int code; бар код
//
//конструктор по умолчанию
//конструктор с инициализацией всех полей
//геттеры и сеттеры с проверкой
//toString()
//
//2) Напишите класс Food наследующий от Product, поля:
// private String expDate; срок годности
// private double calories; колорийность
// private boolean isKosher; кошерный или нет
//
//конструктор по умолчанию
//конструктор с инициализацией всех полей
//геттеры и сеттеры с проверкой
//toString()
//
//3) Напишите класс Drink наследующий от Food с полями:
//  private boolean isNatural;
//  private boolean isSparkling;
//
//конструктор по умолчанию
//конструктор с инициализацией всех полей
//геттеры и сеттеры с проверкой
//toString()
//
//4) Напишите класс AlcoholDrink наследующий от Drink с полем:
// private double percentAlcohol;
//
//конструктор по умолчанию
//конструктор с инициализацией всех полей
//геттеры и сеттеры с проверкой
//toString()
//
//5) Напишите класс MainClassProduct с методом main() создайте объекты типов Product, Food,  Drink, AlcoholDrink.
//Поместите эти объекты в один массив basket
//Создайте метод  который принимает массив продуктов и выводит все на консоль.
//Создайте метод printDrink который принимает массив всех продуктов, но выводит на экран информацию только о 
//объектах порожденных классом Drink.(instanceof не очень подходит....надо подумать...)	


public class MainClassProduct {

	public static void main(String[] args) {
			
		Product[] MyProduct = {	
		new Product("Sanitiser", -10, "Pack 1 Litre", -10),
		new Food("Bread", 1, "box 1kg", 2, "01.01.2021", -200, false),
		new Drink("Milk", 2, "Pack 1 Litre", 3, "01.01.2021", 300, false, true, false),
		new AlcoholDrink("Krucsovica", 2, "Pack 1 Litre", 4, "01.01.2022", 350, false, false, false, 5.5)
	
		};
		
		printProducts(MyProduct);
		System.out.println("===============");
		printDrink(MyProduct);
	}

	private static void printDrink(Product[] myProduct) {
		for (int i = 0; i < myProduct.length; i ++) {
//           if (myProduct[i].ClassType() == "Drink") System.out.println(myProduct[i]);;
             if (myProduct[i].getClass().getName() == "Drink") System.out.println(myProduct[i]);
		}		
	}

	private static void printProducts(Product[] myProduct) {
		for (int i = 0; i < myProduct.length; i ++) {
		    System.out.println(myProduct[i].toString());
		}	
	}
}


