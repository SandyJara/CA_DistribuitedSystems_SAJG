package ds.service2;


	import java.util.List;
	import java.util.concurrent.TimeUnit;
	import java.util.logging.Level;
	import java.util.logging.Logger;

	import io.grpc.ManagedChannel;
	import io.grpc.ManagedChannelBuilder;
	import io.grpc.stub.StreamObserver;


	public class client2 {

		 private static final Logger logger = Logger.getLogger(client2.class.getName());

		    public static String logIn(String name, String password)  throws InterruptedException {
		        String host = "localhost";
		        int port = 50052;
     
		        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
		                .usePlaintext()
		                .build();

		        //Service1Stub stub = Service1Grpc.newStub(channel);
		       
		        Service2Grpc.Service2BlockingStub blockingStub = Service2Grpc.newBlockingStub(channel);
		        
		        
		     // for my login request
		        LogInRequest request = LogInRequest.newBuilder()
		                .setName(name)
		                .setPassword(password)
		                .build();

		        LogInResponse response;
		        
		        try {
		            // here is when is executing the rpc call
		            response = blockingStub.logIn(request);
		            
		            return response.getStatus(); //gets response of the status
		        } catch (Exception e) {
		            logger.log(Level.SEVERE, "Log in unsuccesfull", e);
		            return "Log in unsuccesfull"; // message of errors
		        } finally {
		            channel.shutdownNow(); // Close it
		        }
		        
		    }
		    
		    //Starting my second method here for the update of the information
		   
		    }
