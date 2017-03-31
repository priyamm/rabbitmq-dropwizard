package com.dauble.queue.QueueJob;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

import com.dauble.queue.QueueJob.client.Receiver;
import com.dauble.queue.QueueJob.client.SecondReceiver;
import com.dauble.queue.QueueJob.client.Sender;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DaubleQueueApplication extends Application<DaubleQueueConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DaubleQueueApplication().run(args);
    }

    @Override
    public String getName() {
        return "DaubleQueue";
    }

    @Override
    public void initialize(final Bootstrap<DaubleQueueConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final DaubleQueueConfiguration configuration,
                    final Environment environment) throws KeyManagementException, NoSuchAlgorithmException, IOException, TimeoutException, URISyntaxException, InterruptedException {
    	environment.jersey().register(new Receiver());
    	environment.jersey().register(new Sender());
    	
    	environment.jersey().register(new SecondReceiver());
        // TODO: implement application
    }

}
