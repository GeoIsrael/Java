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

public class Book {
	
	//fields
	private int nPages;
	private String title;
	private String author;
	
	
	//default constructor
	public Book() {} ;    
	
	
	//constructor with fields
	public Book(int nPages, String title, String author) {
        this.author = author;
        this.title = title;
        this.nPages = nPages;
		
	}
	
	//Methods
	public String getAuthor()
	{
		return author;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public int getnPages()
	{
		return nPages;
	}
	
//=========================
	
    public String toString(){
        
        return title + " " + author + " " + nPages;
    }
	
	
}
