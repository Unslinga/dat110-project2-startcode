package no.hvl.dat110.messages;

import no.hvl.dat110.common.TODO;

public class PublishMsg extends Message {

	// message sent from client to create publish a message on a topic 

	// DONE:
	// Implement object variables - a topic and a message is required

	// Constructor, get/set-methods, and toString method
	// as described in the project text

	private String topic;
	private String message;

	public PublishMsg(String user, String topic, String message) {
		super(MessageType.PUBLISH, user);
		this.topic = topic;
		this.message = message;
	}


	public String getTopic() {
		return topic;
	}

	public String getMessage(){
		return message;
	}

	@Override
	public String toString() {
		return super.toString().substring(0, super.toString().length() - 1) + ", topic" + topic + ", message" + message + "]";
	}


}