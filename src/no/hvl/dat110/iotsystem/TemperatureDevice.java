package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.common.TODO;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();

		// DONE - start

		// create a client object and use it to
		Client client = new Client("temperatureDevice","sensor",8080);
		String tmp= "temperature";
		// - connect to the broker
		client.connect();
		// - publish the temperature(s)
		client.publish(tmp,sn.toString());
		// - disconnect from the broker
		client.disconnect();

		// DONE - end

		System.out.println("Temperature device stopping ... ");


	}
}
