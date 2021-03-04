package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messages.MessageType;
import no.hvl.dat110.messages.PublishMsg;
import no.hvl.dat110.common.TODO;
import static no.hvl.dat110.iotsystem.Common.*;

public class DisplayDevice {
	
	private static final int COUNT = 10;
		
	public static void main (String[] args) {
		
		System.out.println("Display starting ...");
		
		// DONE - START
				
		// create a client object and use it to
		Client client = new Client("display",BROKERHOST,BROKERPORT);

		// - connect to the broker
		client.connect();
		// - create the temperature topic on the broker
		client.createTopic(TEMPTOPIC);
		// - subscribe to the topic
		client.subscribe(TEMPTOPIC);
		// - receive messages on the topic

		for (int i= 0; i<COUNT;i++) {
			Message msg = client.receive();
		if(msg.getType() == MessageType.PUBLISH) {
			System.out.println("User: "+msg.getUser() + "\n" + "Temperature: " + ((PublishMsg)msg).getMessage());
		}
		}
		// - unsubscribe from the topic
		client.unsubscribe(TEMPTOPIC);
		// - disconnect from the broker
		client.disconnect();
		
		// DONE - END
		
		System.out.println("Display stopping ... ");
		

		
	}
}
