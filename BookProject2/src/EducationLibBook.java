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


public class EducationLibBook extends LibBook{

	private String subject;

	//Constructors
	
	public EducationLibBook() {} 

    public EducationLibBook(int nPages, String title, String author, int catNumber, String subject) {
		super(nPages, title, author, catNumber);
		if (subject != null && subject.isEmpty()) this.subject = subject;
	}


    // Get/Set

    public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		if (subject != null && subject.isEmpty()) this.subject = subject;
	}
	
	//Methods

    public void display() {              
		System.out.println(this.getnPages()  + "\t" +  this.getAuthor() + "\t" + this.getTitle()  + "\t" +
		this.getCatNumber()  + "\t" + this.getSubject() );
    	
	}
	
	
}
