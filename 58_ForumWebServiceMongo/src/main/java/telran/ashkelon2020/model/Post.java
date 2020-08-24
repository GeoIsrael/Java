package telran.ashkelon2020.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Document(collection = "posts")
public class Post {
	
	Integer id;
	String author;
	String title;
	String content;
	List<String> tags;
	Integer likes;
	LocalDateTime dateTime;
	List<Comment> comments;
	
	public Post(Integer id, String author, String title, String content, List<String> tags) {
		this.id = id;
		this.author = author;
		this.title = title;
		this.content = content;
		this.tags = tags;
		this.likes = 0;
		this.dateTime = LocalDateTime.now();
		
	}
	
	public void addLike() {
		likes++;
	}
	
}
