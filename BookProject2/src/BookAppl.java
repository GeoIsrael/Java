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



public class BookAppl {

	public static void main(String[] args) {
		
		EducationLibBook EB1 = new EducationLibBook(501, "EB1", "Autor1", 1, "subject1");
		EducationLibBook EB2 = new EducationLibBook(502, "EB2", "Autor2", 2, "subject2");
		
		FictionLibBook FB1 = new FictionLibBook(100, "FB1", "Author3", 3, "genre1");
	    FictionLibBook FB2 = new FictionLibBook(101, "FB2", "Author4", 4, "genre2");
		
		

	    FB1.display();
	    FB2.display();
	    EB1.display();
	    EB2.display();
		
		
		
		
		
		
	}
		
//	    Book mybook = new Book(10,"Alise", "L.Carol");
//	    
//	    BookTest.PrintBook(mybook);
//	    
//	    Object[] books = new Object[3];
//	    books[0] = new Book();
//	    books[1] = new Book(100,"Java", "Tim O'Reilly");
//	    books[2] = new Book(500,"Lolita", "Nabokov");
//	    
//	    
//	    for(int i = 0; i < books.length; i++) {
//		    System.out.println(books[i].toString());
//		
//	    }
//	
//	}
//
//	


}
