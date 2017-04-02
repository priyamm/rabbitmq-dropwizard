package com.dauble.queue.QueueJob.client;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import io.dropwizard.lifecycle.Managed;
public class SecondReceiver implements Managed {
		  private final static String QUEUE_NAME = "master";
		  private final Executor executor = Executors.newFixedThreadPool(10);
		  public SecondReceiver() throws KeyManagementException, NoSuchAlgorithmException, IOException, InterruptedException, TimeoutException, URISyntaxException {
				}
		
		@Override
		public void start() throws Exception {
//			ConnectionFactory factory = new ConnectionFactory();
//		    factory.setHost("clam.rmq.cloudamqp.com");
//		    factory.setVirtualHost("ddjaivam");
//		    factory.setPassword("8zcP3ZnW49WlgxbxAjN1rjWiIfRdUde2");
//		    factory.setUri("amqp://ddjaivam:8zcP3ZnW49WlgxbxAjN1rjWiIfRdUde2@clam.rmq.cloudamqp.com/ddjaivam");
//		    Connection connection = factory.newConnection();
//		    Channel channel = connection.createChannel();
//
//		    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//		    System.out.println(" [*] Waiting for messages. To exit press CTRL+C 2");
//		    
//		    Consumer consumer = new DefaultConsumer(channel) {
//		        @Override
//		        public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
//		            throws IOException {
//		          String message = new String(body, "UTF-8");
//		          System.out.println(" [x] Received Consumer 2 '" + message + "'");
//		        }
//		      };
//		    channel.basicConsume(QUEUE_NAME, true, consumer);
			executor.execute(new SecondReceiverHelper());
		}
		@Override
		public void stop() throws Exception {
			// TODO Auto-generated method stub
			
		}
}
