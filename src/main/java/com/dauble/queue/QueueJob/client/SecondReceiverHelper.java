package com.dauble.queue.QueueJob.client;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class SecondReceiverHelper implements Runnable {
	private final static String QUEUE_NAME = "master";
	@Override
	public void run() {
		try {
			ConnectionFactory factory = new ConnectionFactory();
		    factory.setHost("clam.rmq.cloudamqp.com");
		    factory.setVirtualHost("ddjaivam");
		    factory.setPassword("8zcP3ZnW49WlgxbxAjN1rjWiIfRdUde2");
		    factory.setUri("amqp://ddjaivam:8zcP3ZnW49WlgxbxAjN1rjWiIfRdUde2@clam.rmq.cloudamqp.com/ddjaivam");
		    Connection connection = factory.newConnection();
		    Channel channel = connection.createChannel();

		    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		    System.out.println(" [*] Waiting for messages. To exit press CTRL+C 2");
		    
		    Consumer consumer = new DefaultConsumer(channel) {
		        @Override
		        public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
		            throws IOException {
		          String message = new String(body, "UTF-8");
		          System.out.println(" [x] Received Consumer 2 '" + message + "'");
		          try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        }
		      };
		    channel.basicConsume(QUEUE_NAME, true, consumer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
