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
//5) Напишите класс MainClassProduct с методом main() создайте объекты типов Product, Food, Drink, AlcoholDrink.
//Поместите эти объекты в один массив basket
//Создайте метод printProducts который принимает массив продуктов и выводит все на консоль.
//Создайте метод printDrink который принимает массив всех продуктов, но выводит на экран информацию только о 
//объектах порожденных классом Drink.(instanceof не очень подходит....надо подумать...)	


public class Product {

	//Fields
	private String name;  // Наименование
    private double price; // цена
    private String mItem; // тип тары, например:box 1kg или Pack 1 Litre
    private int code;     //бар код
	
    
    // Constructors
    public Product() {}
	public Product(String name, double price, String mItem, int code) {
		setName(name);
		setPrice(price);
		setmItem(mItem);
		setCode(code);
	}

	
	//Get/Set
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if (name != null && name.isEmpty()) this.name = "none";
		else this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		if (price > 0) this.price = price;
		else this.price = 0;
	}
	public String getmItem() {
	   return mItem;
	}
	public void setmItem(String mItem) {
		if (mItem != null && mItem.isEmpty())  this.mItem = "none";
		else this.mItem = mItem;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		if (code > 0) this.code = code;
		else code = 0;
	}

	public String ClassType() {
		return "Product";
	}
	
	 //toString()
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", mItem=" + mItem + ", code=" + code + "]";
	}
	 
	 

}
