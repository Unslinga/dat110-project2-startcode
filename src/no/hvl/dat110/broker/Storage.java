package no.hvl.dat110.broker;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import no.hvl.dat110.common.TODO;
import no.hvl.dat110.common.Logger;
import no.hvl.dat110.messagetransport.Connection;

public class Storage
{

    // data structure for managing subscriptions
    // maps from a topic to set of subscribed users
    protected ConcurrentHashMap<String, Set<String>> subscriptions;

    // data structure for managing currently connected clients
    // maps from user to corresponding client session object

    protected ConcurrentHashMap<String, ClientSession> clients;

    public Storage()
    {
        subscriptions = new ConcurrentHashMap<String, Set<String>>();
        clients = new ConcurrentHashMap<String, ClientSession>();
    }

    public Collection<ClientSession> getSessions()
    {
        return clients.values();
    }

    public Set<String> getTopics()
    {

        return subscriptions.keySet();

    }

    // get the session object for a given user
    // session object can be used to send a message to the user

    public ClientSession getSession(String user)
    {

        ClientSession session = clients.get(user);

        return session;
    }

    public Set<String> getSubscribers(String topic)
    {
        // Needed to fix this method, was throwing nullpointer exception.
        // really guys...?

        if (!subscriptions.containsKey(topic))
        {
            Logger.log("topic does not contain any subscribers");
            return new HashSet<>();
        }

        return (subscriptions.get(topic));
    }

    public void addClientSession(String user, Connection connection)
    {
		// DONE: add corresponding client session to the storage
		if (!clients.containsKey(user))
		{
			ClientSession session = new ClientSession(user, connection);
			clients.put(user, session);
			return;
		}
        Logger.log("ERROR: Client already exists!");
    }

    public void removeClientSession(String user)
    {
        // DONE: remove client session for user from the storage
		if (clients.containsKey(user))
		{
			clients.remove(user);
			return;
		}
        Logger.log("ERROR: Client does not exist!");
    }

    public void createTopic(String topic)
    {
        // DONE: create topic in the storage
		if (!subscriptions.containsKey(topic))
		{
			subscriptions.put(topic, new HashSet<>());
			return;
		}
        Logger.log("ERROR: Topic already exists!");
    }

    public void deleteTopic(String topic)
    {
        // DONE: delete topic from the storage
		if (subscriptions.containsKey(topic))
		{
			subscriptions.remove(topic);
			return;
		}
        Logger.log("ERROR: Topic does not exist!");
    }

    public void addSubscriber(String user, String topic)
    {
        // DONE: add the user as subscriber to the topic
		if (subscriptions.containsKey(topic))
		{
			if (!subscriptions.get(topic).contains(user))
			{
				subscriptions.get(topic).add(user);
				return;
			}
            Logger.log("ERROR: User already subrscribed to topic!");
			return;
		}
        Logger.log("ERROR: Topic does not exist!");
    }

    public void removeSubscriber(String user, String topic)
    {
        // DONE: remove the user as subscriber to the topic
		if (subscriptions.containsKey(topic))
		{
			if (subscriptions.get(topic).contains(user))
			{
				subscriptions.get(topic).remove(user);
				return;
			}
			Logger.log("ERROR: User is not subrscribed to topic!");
            return;
		}
        Logger.log("ERROR: Topic does not exist!");
    }
}
