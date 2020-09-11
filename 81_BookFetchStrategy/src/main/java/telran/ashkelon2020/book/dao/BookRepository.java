package telran.ashkelon2020.book.dao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import telran.ashkelon2020.book.model.Author;
import telran.ashkelon2020.book.model.Book;

@Repository
public class BookRepository {

	@PersistenceContext//(type = PersistenceContextType.EXTENDED)
	EntityManager em;
	
	@Transactional
	public void addBooks() {
		Author markTwain = new Author("Mark Twain");
		em.persist(markTwain);
		Book pandp = new Book("978-0140350173", "The Prince and the Pauper",
				new HashSet<>(Arrays.asList(markTwain)));
		em.persist(pandp);
		Author ilf = new Author("Ilya Ilf");
		em.persist(ilf);
		Author petrov = new Author("Evgeny Petrov");
		em.persist(petrov);
		Book chairs12 = new Book("978-0810114845", "The Twelve chairs", 
				new HashSet<>(Arrays.asList(ilf,petrov)));
		em.persist(chairs12);	
	}
	
	//@Transactional(readOnly = true)
	public void printAuthorsOfBook(String isbn) {
		TypedQuery<Book> query = em.createQuery("select b from Book b left join fetch b.authors a where b.isbn=?1", Book.class);
		query.setParameter(1, isbn);
		Book book = query.getSingleResult();
		//Book book = em.find(Book.class, isbn);
		Set<Author> authors = book.getAuthors();
		authors.forEach(a -> System.out.println(a.getName()));
	}
}
