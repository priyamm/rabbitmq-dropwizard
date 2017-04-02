package com.dauble.queue.QueueJob.client;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;

import io.dropwizard.lifecycle.Managed;

public class Sender implements Managed {
	private final static String QUEUE_NAME = "slave";
	private final Executor executor = Executors.newFixedThreadPool(10);
	public Sender() throws KeyManagementException, NoSuchAlgorithmException, IOException, TimeoutException, URISyntaxException, InterruptedException {
		
	}

	@Override
	public void start() throws Exception {
		executor.execute(new SenderHelper());
	}

	@Override
	public void stop() throws Exception {
		// TODO Auto-generated method stub
	}
}
