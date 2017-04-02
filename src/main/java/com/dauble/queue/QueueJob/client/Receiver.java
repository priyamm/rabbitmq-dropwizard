package com.dauble.queue.QueueJob.client;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;

import io.dropwizard.lifecycle.Managed;
public class Receiver implements Managed {
	private final Executor executor = Executors.newFixedThreadPool(10);
		  public Receiver() throws KeyManagementException, NoSuchAlgorithmException, IOException, InterruptedException, TimeoutException, URISyntaxException {
			
		}
		@Override
		public void start() throws Exception {
			 executor.execute(new ReceiverHelper());
			
		}
		@Override
		public void stop() throws Exception {
			// TODO Auto-generated method stub
			
		}
}
