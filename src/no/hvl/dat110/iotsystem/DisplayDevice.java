package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messages.PublishMsg;
import no.hvl.dat110.common.TODO;

public class DisplayDevice {
	
	private static final int COUNT = 10;
		
	public static void main (String[] args) {
		
		System.out.println("Display starting ...");
		
		// DONE - START
				
		// create a client object and use it to
		Client client = new Client("display","sensor",8080);
		String tmp= "temperature";
		// - connect to the broker
		client.connect();
		// - create the temperature topic on the broker
		client.createTopic(tmp);
		// - subscribe to the topic
		client.subscribe(tmp);
		// - receive messages on the topic
		client.receive();
		// - unsubscribe from the topic
		client.unsubscribe(tmp);
		// - disconnect from the broker
		client.disconnect();
		
		// DONE - END
		
		System.out.println("Display stopping ... ");
		

		
	}
}
