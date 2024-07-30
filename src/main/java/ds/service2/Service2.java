
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


}
