package com.dauble.queue.QueueJob.client;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class LogstashHelper implements Runnable{
	
	 private final static String QUEUE_NAME = "log";
	 private final static Logger logger = LogManager.getLogger(SenderHelper.class.getName());
	@Override
	public void run() {
		try{
			ConnectionFactory factory = new ConnectionFactory();
		    factory.setHost("clam.rmq.cloudamqp.com");
		    factory.setVirtualHost("ddjaivam");
		    factory.setPassword("8zcP3ZnW49WlgxbxAjN1rjWiIfRdUde2");
		    factory.setUri("amqp://ddjaivam:8zcP3ZnW49WlgxbxAjN1rjWiIfRdUde2@clam.rmq.cloudamqp.com/ddjaivam");
		    Connection connection = factory.newConnection();
		    Channel channel = connection.createChannel();

		    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
		    
		    Consumer consumer = new DefaultConsumer(channel) {
		        @Override
		        public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
		            throws IOException {
		          String message = new String(body, "UTF-8");
		          logger.info("Received From LogStash '" + message + "'");
		        }
		      };
		    channel.basicConsume(QUEUE_NAME, true, consumer);
		} catch(Exception e){
			e.printStackTrace();
		}
	}



}
