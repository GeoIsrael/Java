package telran.ashkelon2020.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import telran.ashkelon2020.model.Comment;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDto {

	Integer id;
	String title;
	String content;
	String author;
	LocalDateTime dateTime;
	List <String> tags;
	Integer likes;
	List<Comment> comments;
	
	
}



