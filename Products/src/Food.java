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


public class Food extends Product {

	//Fields
	 private String expDate; //срок годности
	 private double calories; //колорийность
	 private boolean isKosher; //кошерный или нет
	
	 
     //Constructors
	 public Food() {}
	 
	 public Food(String name, double price, String mItem, int code, String expDate, double calories, boolean isKosher) {
		super(name, price, mItem, code);
		setExpDate(expDate);
		setCalories(calories);
		setKosher(isKosher);
	}

	 
	//Get/Set
	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		if (expDate != null && expDate.isEmpty()) this.expDate = "no date";
		else this.expDate = expDate;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		if (calories > 0)  this.calories = calories;
		else this.calories = 0;
	}

	public boolean isKosher() {
		return isKosher;
	}

	public void setKosher(boolean isKosher) {
		this.isKosher = isKosher;
	}

	public String ClassType() {
		return "Food";
	}
	
	
	//toString
	@Override
	public String toString() {
		return "Food [name=" + getName() + ", price=" + getPrice() + ", mItem=" + getmItem()
				+ ", code=" + getCode() + ", expDate=" + getExpDate() + ", calories=" 
				    + getCalories() + ", kosher=" + isKosher() + "]";
	}

	 

	 
	
	
	
}
