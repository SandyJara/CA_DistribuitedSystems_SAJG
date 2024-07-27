
package ds.service2;

import java.io.IOException;

import generated.ds.service2.RequestLogIn;
import generated.ds.service2.ResponseLogIn;
import generated.ds.service2.Service2Grpc.Service2ImplBase; 
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
	public void service2Do(RequestLogIn request, StreamObserver<ResponseLogIn> responseObserver) {

		//prepare the value to be set back
				
		//preparing the response message
		ResponseLogIn reply1 = ResponseLogIn.newBuilder().setMessage("SESION INICIADA").build();

		responseObserver.onNext( reply1 ); 
	

		responseObserver.onCompleted();

	}
}
