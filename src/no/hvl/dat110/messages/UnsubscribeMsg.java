package no.hvl.dat110.messages;

public class UnsubscribeMsg extends Message {

	// message sent from client to unsubscribe on a topic 

	// DONE:
	// Implement object variables - a topic is required

	// Constructor, get/set-methods, and toString method
	// as described in the project text

    private  String topic;

    public UnsubscribeMsg (String user, String topic){
        super(MessageType.UNSUBSCRIBE, user);
        this.topic= topic;
    }


    public String getTopic() {
        return topic;
    }

    @Override
    public String toString() {
        return super.toString().substring(0,super.toString().length()-1) + ", topic" +topic + "]";
    }
}
