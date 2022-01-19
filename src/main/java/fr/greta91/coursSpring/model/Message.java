package fr.greta91.coursSpring.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Message {
	private int id;
	
	@NotBlank(message = "Message ne peut pas être vide !")
	@NotNull(message = "Message ne peut pas être vide !")
	private String message;

	public Message() {
	}
	
	public Message(String message) {
		this.message = message;
	}
	
	public Message(int id, String message) {
		this.id = id;
		this.message = message;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public boolean validate() {
		if(this.message.trim().isEmpty()) {
			return false;
		}
		return true;
	}
}
