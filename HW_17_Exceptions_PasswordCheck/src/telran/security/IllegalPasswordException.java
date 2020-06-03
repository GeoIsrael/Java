package telran.security;

@SuppressWarnings("serial")
public class IllegalPasswordException extends Exception {                   
	
private String[]messages;

public String[] getMessages() {
	return messages;
}
public IllegalPasswordException(String[]messages) {
	this.messages=messages;
}

}
