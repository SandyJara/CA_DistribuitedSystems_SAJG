package ds.service1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import ds.service1.client1;
import ds.service1.Service1Grpc.Service1Stub;
import ds.service1.Service1Grpc.Service1Stub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class client1 {

	 private static final Logger logger = Logger.getLogger(client1.class.getName());

	    public static String startTemperatureControl()  throws InterruptedException {
	        String host = "localhost";
	        int port = 50051;

	       // final String[] responseMessage = {null};   When i didnt use the arrayList, the response in my GUI WAS just "Action from server received: null", It wasn't printing all while it executed it
	       final List<String> actions = new ArrayList<>();
       
	        
	        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
	                .usePlaintext()
	                .build();

	        //Service1Stub stub = Service1Grpc.newStub(channel);
	        Service1Grpc.Service1Stub stub = Service1Grpc.newStub(channel);
	        
	        StreamObserver<ControlRequest> requestStreamObserver = stub.controlTemperature(new StreamObserver<ControlResponse>() { //it changed because I needed to add the streaming (not the unary response)
	            @Override
	            public void onNext(ControlResponse response) {
	                String action = response.getAction();
	                logger.info("Action from server received: " + action);
	                actions.add(action);//to add in my Array List
	            }

	            @Override
	            public void onError(Throwable t) {
	                logger.log(Level.WARNING, "Temperature controle NOT POSSIBLE to execute", t);
	            }

	            @Override
	            public void onCompleted() {
	                logger.info("Temperature control FINISHED satisfactory");
	            }
	        }
	        );

	        // Simulate sending temperature readings every few seconds
	        try {
	            for (int temperature =22 ; temperature <= 25; temperature++) { //this are just as an example to test my code, in real life it's supposed the number should be got by the real temperature
	            	//in real life the lecture of the temperature should be all the time needed while the library has operations
	            	ControlRequest request = ControlRequest.newBuilder().setTemperature(temperature).build();
	                requestStreamObserver.onNext(request);
	                Thread.sleep(2000); // Adding some waiting time between my readings and the response needed
	            }
	        } catch (Exception e) {
	            requestStreamObserver.onError(e);
	            throw e;
	        } finally {
	            requestStreamObserver.onCompleted();
	            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	        }
	        if (actions.isEmpty()) {
	            return "No actions received";
	        } else {
	            return "SUCCESSFUL Temperature Control";
	        }
	    }
	}