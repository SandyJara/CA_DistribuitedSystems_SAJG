package ds.service2;


	import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
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
		    public static String updateProfile(List<updateProfileRequest> requests, StreamObserver<updateProfileResponse> streamObserver) {
		        System.out.println("updateProfile method called.");
		        String host = "localhost";
		        int port = 50052;

		        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
		                .usePlaintext()
		                .build();

		        Service2Grpc.Service2Stub asyncStub = Service2Grpc.newStub(channel);

		        StringBuilder responseBuilderUpdateProfile = new StringBuilder();
		        CountDownLatch finishLatch = new CountDownLatch(1);
		        
		        
		        StreamObserver<updateProfileResponse> responseObserver = new StreamObserver<updateProfileResponse>() {
		            @Override
		            public void onNext(updateProfileResponse response) {
		                System.out.println("Received response: " + response.getStatus());  // TESTING that is updating
		                responseBuilderUpdateProfile.append("Update response: ").append(response.getStatus()).append("\n");
		              
		            }

		            @Override
		            public void onError(Throwable t) {
		                System.err.println("Update profile failed: " + t.getMessage());  // TESTING 
		                responseBuilderUpdateProfile.append("Update profile failed: ").append(t.getMessage()).append("\n");
		                finishLatch.countDown(); // Signal completion
		            }

		            @Override
		            public void onCompleted() {
		            	System.out.println("Profile update completed.");  // TEST
		            	//String completedUpdate = "Profile update completed."; 
		                responseBuilderUpdateProfile.append("Profile update completed.\n");
		                finishLatch.countDown(); // Signal completion
		            }
		        };

		        StreamObserver<updateProfileRequest> requestObserver = asyncStub.updateProfile(responseObserver);

		        
		        try {
		            for (updateProfileRequest request : requests) {
		                requestObserver.onNext(request);
		            }
		            requestObserver.onCompleted();
		        } catch (RuntimeException e) {
		            requestObserver.onError(e);
		            throw e;
		        }

		        try {
		            channel.awaitTermination(1, TimeUnit.MINUTES);
		        } catch (InterruptedException e) {
		            System.err.println("Thread interrupted: " + e.getMessage());  
		        }

		        return responseBuilderUpdateProfile.toString();
		    }

			public String getCompletedUpdate() {
				// TODO Auto-generated method stub
				return null;
			}

			public void setCompletedUpdate(String status) {
				// TODO Auto-generated method stub
				
			}
			
	//code added to run my client2 class
			public static void main(String[] args) throws InterruptedException {
				String loginStatus = logIn("testUser", "testPassword");
		        System.out.println("Login Status: " + loginStatus);
		    }
			
			
		}
		     
		   
