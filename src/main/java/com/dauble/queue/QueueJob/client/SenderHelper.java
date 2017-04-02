package com.dauble.queue.QueueJob.client;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class SenderHelper implements Runnable {
	private final static String QUEUE_NAME = "master";
	private final static Logger logger = LogManager.getLogger(SenderHelper.class.getName());
//	Logger logger = LogManager.getRootLogger();
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

			channel.exchangeDeclare("dauble", "fanout");

			// channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			String message = "Hello World!";
			for (int i = 0; i < 500; i++) {
				logger.error("Server Working..");
				channel.basicPublish("dauble", "", null, message.getBytes());
				System.out.println(" [x] Sent '" + message + "'");
				channel.basicPublish("dauble", "", null, "Priyam Gupta".getBytes());
				System.out.println(" [x] Sent '-Priyam Gupta-'");
				Thread.sleep(1000);
			}
			channel.close();
			connection.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}

}
