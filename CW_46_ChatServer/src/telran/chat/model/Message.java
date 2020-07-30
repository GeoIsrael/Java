package telran.chat.model;

import java.io.Serializable;
import java.time.LocalTime;

public class Message implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nickName;
	String message;
	LocalTime time;

	public Message() {
	}

	public Message(String nickName) {
		this.nickName = nickName;
	}

	public Message(String nickName, String message, LocalTime time) {
		this.nickName = nickName;
		this.message = message;
		this.time = time;
	}
	
	public Message(String nickName, String message) {
		this.nickName = nickName;
		this.message = message;
		this.time = LocalTime.now();
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "[" + time + "] " + nickName + ": " + message;
	}

}
