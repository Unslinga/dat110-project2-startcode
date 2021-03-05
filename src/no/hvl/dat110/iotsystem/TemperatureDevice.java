package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import static no.hvl.dat110.iotsystem.Common.*;
import no.hvl.dat110.common.TODO;

public class TemperatureDevice
{

    private static final int COUNT = 10;

    public static void main(String[] args)
    {

        // simulated / virtual temperature sensor
        TemperatureSensor sn = new TemperatureSensor();

        // DONE - start

        // create a client object and use it to
        var client = new Client("TemperatureSensor", BROKERHOST, BROKERPORT);
        // - connect to the broker
        client.connect();
        // - publish the temperature(s)
        for (int i = 0; i < COUNT; i++)
        {
            client.publish(TEMPTOPIC, "" + sn.read());
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException e){}
        }
        // - disconnect from the broker
        client.disconnect();

        // DONE - end

        System.out.println("Temperature device stopping ... ");
    }
}
