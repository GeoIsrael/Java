package telran.ashkelon2020.book.dao;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import telran.ashkelon2020.book.model.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, String> {
	
	//@Query("select distinct b.publisher.publisherName from Book b join b.authors a where a.name=?1")
	@Query("select distinct p.publisherName from Book b join b.authors a join b.publisher p where a.name=?1")
	List<String> findPublisherByAuthor(String authorName);
	
	Stream<Publisher> findDistinctByBooksAuthorsName(String authorName);
}
