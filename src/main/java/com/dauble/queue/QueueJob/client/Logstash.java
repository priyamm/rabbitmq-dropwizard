package com.dauble.queue.QueueJob.client;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import io.dropwizard.lifecycle.Managed;

public class Logstash implements Managed {
	private final Executor executor = Executors.newFixedThreadPool(10);
	@Override
	public void start() throws Exception {
		executor.execute(new LogstashHelper());
		
	}

	@Override
	public void stop() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
