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


public class Drink extends Food {

    //Fields
    private boolean isNatural;
    private boolean isSparkling;

	
   
    //Constructors
    public Drink() {}
    
    public Drink(String name, double price, String mItem, int code, String expDate, double calories, boolean isKosher,
			boolean isNatural, boolean isSparkling) {
		super(name, price, mItem, code, expDate, calories, isKosher);
		this.isNatural = isNatural;
		this.isSparkling = isSparkling;
	}

    
	
    
  //Get/Set
    public boolean isNatural() {
		return isNatural;
	}

	public void setNatural(boolean isNatural) {
		this.isNatural = isNatural;
	}

	public boolean isSparkling() {
		return isSparkling;
	}

	public void setSparkling(boolean isSparkling) {
		this.isSparkling = isSparkling;
	}

	public String ClassType() {
		return "Drink";
	}

	
    
    //ToString

	@Override
	public String toString() {
		return "Drink [name=" + getName() + ", price=" + getPrice() + ", mItem=" + getmItem() + ", code=" + getCode() +
				 ", expDate=" + getExpDate() + ", calories=" + getCalories() + ", isKosher=" + isKosher() +
				 " isNatural=" + isNatural() + ", isSparkling=" + isSparkling() + "]";
	}

	



	

	
    
    
    
    
   
    
   
   
   
   
	
}
