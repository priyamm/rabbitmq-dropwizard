package com.dauble.queue.QueueJob.client;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
public class Receiver {
		  private final static String QUEUE_NAME = "slave";
		  public Receiver() throws KeyManagementException, NoSuchAlgorithmException, IOException, InterruptedException, TimeoutException, URISyntaxException {
			main1(null);
		}
		  public static void main1(String[] argv)
		      throws java.io.IOException,
		             java.lang.InterruptedException, TimeoutException, KeyManagementException, NoSuchAlgorithmException, URISyntaxException {

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
		          System.out.println(" [x] Received Consumer '" + message + "'");
		          try {
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        }
		      };
		    channel.basicConsume(QUEUE_NAME, true, consumer);
		    
		    }
}
