package ds.service1;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

import ds.service1.Service1Grpc.Service1ImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;



public class Service1 extends Service1ImplBase{
    private Server server;

    public void startMe() {
        try {
            int port = 50051;
            server = ServerBuilder.forPort(port)
                    .addService(this)
                    .build()
                    .start();
            System.out.println("Service-1 started, listening on " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopMe() {
        if (server != null) {
            server.shutdown();
        }
    }
	
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
				
		Service1 service1 = new Service1();
//		int port = 50051;
		service1.startMe();
        service1.server.awaitTermination();
		//Server server = ServerBuilder.forPort(port)
		//		.addService(service1)
		//		.build()
		//		.start();

		//System.out.println("Service-1 started, listening on " + port);

		//server.awaitTermination();
	}


	@Override
    public StreamObserver<ControlRequest> controlTemperature(StreamObserver<ControlResponse> responseObserver) {
        return new StreamObserver<ControlRequest>() { //i had to change to streaming consideration
            @Override
            public void onNext(ControlRequest request) {
                int temperature = request.getTemperature();  //declaring temperature as integer
                String action = determineAction(temperature); // Determine what to do depending on what temperature I have
                ControlResponse response = ControlResponse.newBuilder().setAction(action).build();
                responseObserver.onNext(response); // Sending to the client the action executing 
          
             
            }
            
       
			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				
			}      
			
			  
        };
    }

	//For the lights 
	 @Override
	    public void controlLights(LightRequest request, StreamObserver<LightResponse> responseObserver) {
	        boolean turnOn = request.getTurnOn();
	        String status = turnOn ? "Lights are turned on" : "Lights are turned off";
	        LightResponse response = LightResponse.newBuilder().setStatus(status).build();
	        responseObserver.onNext(response);
	        responseObserver.onCompleted();
	    }


	
	
	//making the actions to take in the control temperature
	
    private String determineAction(int temperature) {
    	String ResponseMessage;
        if (temperature > 22) {
        	ResponseMessage = "Decreasing temperature";
            return ResponseMessage;
        } else if (temperature < 21) {
        	ResponseMessage = "Increasing temperature";
            return ResponseMessage;
         } else {
        	 ResponseMessage = "Keeping temperature";
            return ResponseMessage ;
        }
    }
}

