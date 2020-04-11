
public class Book {
	
	//fields
	private int nPages;
	private String title;
	private String author;
	
	
	//default constructor
	public Book() {} ;    
	
	
	//constructor with fields
	public Book(int i_nPages, String i_title, String i_author) {
        author = i_author;
        title = i_title;
        nPages = i_nPages;
		
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
