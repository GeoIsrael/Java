//Внести изменения в дз
//
//Написать класс Book - с полями автор, название и количество страниц - это уже сделали
//
//Написать класс наследующий от Book - LibBook(с полем private int catNumber), 
//от него написать  класс наследник FictionLibBook(c полем private String genre) и 
//написать класс наследник тоже от LibBook EducationLibBook(c полем private String subject)
//в каждом из последних реализовать метод display
//во всех классах конструктора с пустыми параметрами и конструктора с инициализацией всех полей,
//геттеры и сеттеры.(Сделайте проверки в сеттерах и конструкторе с инициализацией всех полей).
//
//Написать класс BookAppl с методом main(), в нем создать объекты классов EducationLibBook и
//FictionLibBook и вызвать у объектов метод display
//
//Удачи!

public class LibBook extends Book{
	
	private int catNumber;

	//Constructors
	
	public LibBook() {}

	public LibBook(int nPages, String title, String author, int catNumber) {
		super(nPages, title, author);
		if (catNumber > 0) this.catNumber = catNumber;
	}

	
	// Get/Set
	
	public int getCatNumber() {
		return catNumber;
	}

	public void setCatNumber(int catNumber) {
		if (catNumber > 0) this.catNumber = catNumber;
	}
	

	
}

