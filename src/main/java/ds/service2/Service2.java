
package ds.service2;

import java.io.IOException;

import ds.service2.LogInRequest;
import ds.service2.LogInResponse;
import ds.service2.Service2Grpc.Service2ImplBase; 
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;


public class Service2 extends Service2ImplBase{



	public static void main(String[] args) throws InterruptedException, IOException {
		Service2 service2 = new Service2();

		int port = 50052;

		Server server = ServerBuilder.forPort(port)
				.addService(service2)
				.build()
				.start();

		System.out.println("Service-2 started, listening on " + port);

		server.awaitTermination();
	}

@Override 
	public void logIn(LogInRequest request, StreamObserver<LogInResponse> responseObserver) {

		String name = request.getName();
        String password = request.getPassword();
		
       // This to give message for the status
        String status;
        
     // Perform login validation
		   if (name == null || name.isEmpty() || password == null || password.isEmpty()) {
		      status = "Some information is missed to be able to Log In";
		   } else {
		       status = "Login successful";
		          
		   }    
        
		   // Preparing and sending the response message
	        LogInResponse reply = LogInResponse.newBuilder().setStatus(status).build();
	        responseObserver.onNext(reply);
	        responseObserver.onCompleted();
	}

//ADDING HERE MY SECOND METHOD TO UPDATE THE INFORMATION OF THE USER

@Override
public StreamObserver<updateProfileRequest> updateProfile(final StreamObserver<updateProfileResponse> responseObserver) {
    return new StreamObserver<updateProfileRequest>() {
        private StringBuilder messageBuilder = new StringBuilder();

        @Override
        public void onNext(updateProfileRequest request) {
            // Process each update request
            if (request.getName() != null && !request.getName().isEmpty()) {
                // Update name logic here
                messageBuilder.append("Name updated to ").append(request.getName()).append("\n");
            }
            if (request.getPassword() != null && !request.getPassword().isEmpty()) {
                // Update password logic here
                messageBuilder.append("Password updated\n");
            }
            if (request.getStatus() != null && !request.getStatus().isEmpty()) {
                // Update status logic here
                messageBuilder.append("Status updated to ").append(request.getStatus()).append("\n");
            }
            if (request.getAddress() != null && !request.getAddress().isEmpty()) {
                // Update address logic here
                messageBuilder.append("Address updated to ").append(request.getAddress()).append("\n");
            }
            if (request.getPhoneNumber() != null && !request.getPhoneNumber().isEmpty()) {
                // Update phone number logic here
                messageBuilder.append("Phone number updated to ").append(request.getPhoneNumber()).append("\n");
            }
        }

        @Override
        public void onError(Throwable t) {
            t.printStackTrace();
        }

        @Override
        public void onCompleted() {
            updateProfileResponse response = updateProfileResponse.newBuilder()
                    .setStatus(messageBuilder.toString())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    };
}


}
