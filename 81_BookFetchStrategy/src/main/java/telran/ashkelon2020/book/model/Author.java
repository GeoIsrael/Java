package telran.ashkelon2020.book.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"name"})
@Entity
public class Author {
	@Id
	String name;
	@ManyToMany(mappedBy = "authors")
	Set<Book> books;
	public Author(String name) {
		this.name = name;
	}
	
	

}
