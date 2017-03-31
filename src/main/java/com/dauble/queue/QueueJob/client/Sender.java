package com.dauble.queue.QueueJob.client;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;

public class Sender {
	private final static String QUEUE_NAME = "slave";
	public Sender() throws KeyManagementException, NoSuchAlgorithmException, IOException, TimeoutException, URISyntaxException, InterruptedException {
		main1(null);
	}

	  public static void main1(String[] argv)
	      throws java.io.IOException, TimeoutException, KeyManagementException, NoSuchAlgorithmException, URISyntaxException, InterruptedException {
		  ConnectionFactory factory = new ConnectionFactory();
		    factory.setHost("clam.rmq.cloudamqp.com");
		    factory.setVirtualHost("ddjaivam");
		    factory.setPassword("8zcP3ZnW49WlgxbxAjN1rjWiIfRdUde2");
		    factory.setUri("amqp://ddjaivam:8zcP3ZnW49WlgxbxAjN1rjWiIfRdUde2@clam.rmq.cloudamqp.com/ddjaivam");
		    Connection connection = factory.newConnection();
		    Channel channel = connection.createChannel();
		    
		    channel.exchangeDeclare("dauble", "fanout");
		    
//		    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		    String message = "Hello World!";
		    for(int i = 0 ; i < 500 ; i ++){
		    	channel.basicPublish("dauble", "", null, message.getBytes());
		    	System.out.println(" [x] Sent '" + message + "'");
			    channel.basicPublish("dauble", "", null, "Priyam Gupta".getBytes());
			    System.out.println(" [x] Sent '-Priyam Gupta-'");
			    
			    Thread.sleep(1000);
		    }
		    
		    
		    channel.close();
		    connection.close();
	  }
}
