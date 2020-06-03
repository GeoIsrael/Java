package telran.exceptions;

public class NumberGreaterMaxException extends Exception{

	public NumberGreaterMaxException(String message) {
		super(message);                 //в родительский класс при создании будет переаваться message
		
	}
}
