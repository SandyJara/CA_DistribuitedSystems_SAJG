package ds.service3;


	//import java.util.List;
	import java.util.concurrent.TimeUnit;
	import java.util.logging.Level;
	import java.util.logging.Logger;

	import io.grpc.ManagedChannel;
	import io.grpc.ManagedChannelBuilder;
	import io.grpc.stub.StreamObserver;


	public class client3 {

	    private static final Logger logger = Logger.getLogger(client3.class.getName());

	    public static void main(String[] args) throws InterruptedException {

	        ManagedChannel channel = ManagedChannelBuilder
	                .forAddress("localhost", 50053)
	                .usePlaintext()
	                .build();

	        Service3Grpc.Service3Stub asyncStub = Service3Grpc.newStub(channel);

	        String topic = "Science";  // Example of a topic (I NEED TO CHANGE THIS TO BE GIVEN IN THE GUI BY THE USER)

	        SearchBookRequest request = SearchBookRequest.newBuilder()
	                .setTopic(topic)
	                .build();

	        StreamObserver<SearchBookResponse> responseObserver = new StreamObserver<SearchBookResponse>() {
	            @Override
	            public void onNext(SearchBookResponse response) {
	                if (response.getSearchFinished()) {
	                    logger.info("Search was completed.");
	                } else {
	                    logger.info("Book found: " + response.getTitle() + " by " + response.getAuthor() +
	                            ", Description: " + response.getDescription() + ", Year: " + response.getYear());
	                }
	            }

	            @Override
	            public void onError(Throwable t) {
	                logger.log(Level.SEVERE, "Search failed:", t);
	            }

	            @Override
	            public void onCompleted() {
	                logger.info("Search finished.");
	            }
	        };

	        asyncStub.searchBook(request, responseObserver);

	        // Waiting time for the response
	        channel.awaitTermination(1, TimeUnit.MINUTES);
	    }
	}