package telran.ashkelon2020.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString

public class Comment {

	String user;
	String message;
	LocalDateTime dateTime;
	Integer likes;
	
	
}
