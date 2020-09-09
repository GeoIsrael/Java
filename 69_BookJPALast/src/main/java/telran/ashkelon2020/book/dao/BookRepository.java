package telran.ashkelon2020.book.dao;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;

import telran.ashkelon2020.book.model.Book;

public interface BookRepository extends JpaRepository<Book, String> {
//	Stream<Book> findByAuthorsName(String authorName);
//
//	Stream<Book> findByPublisherPublisherName(String publisherName);
	
	long deleteByAuthorsName(String authorName);
}
