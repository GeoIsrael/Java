//Создайте класс - Book с полями:
//	private int nPages;
//	private String title;
//	private String author;
//
//- Создайте конструктор по умолчанию
//- Создайте еще один конструктор принимающий значения для всех полей
//
//Создайте другой класс - BookTest. В нем:
//- Создайте статический метод, выводящий данные книги на консоль


//- В main() методе создайте массив из 3 книг (используйте оба конструктора), 
//наполните его разными книгами, и выведите на консоль содержимое массива.


public class MainClass {

	public static void main(String[] args) {
		
	    Book mybook = new Book(10,"Alise", "L.Carol");
	    
	    BookTest.PrintBook(mybook);
	    
	    Object[] books = new Object[3];
	    books[0] = new Book();
	    books[1] = new Book(100,"Java", "Tim O'Reilly");
	    books[2] = new Book(500,"Lolita", "Nabokov");
	    
	    
	    for(int i = 0; i < books.length; i++) {
		    System.out.println(books[i].toString());
		
	    }
	
	}

	


}
