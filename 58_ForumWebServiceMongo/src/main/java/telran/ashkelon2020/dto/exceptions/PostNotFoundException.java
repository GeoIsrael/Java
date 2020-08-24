package telran.ashkelon2020.dto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
@NoArgsConstructor
public class PostNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public PostNotFoundException(int id) {
		super("Post with id " + id + " not found");
	}
	
	
}
