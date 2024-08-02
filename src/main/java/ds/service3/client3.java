package ds.service3;


	import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
	        
	        Scanner scanner = new Scanner(System.in);
	        
	        
	        //String topic = "Science";  // Example of a topic (I didnt add this to GUI, it will be show here in the console)
	        System.out.print("Enter topic to search for (between: Science, Fiction, Literature, Thriller): ");
	        String topic = scanner.nextLine();
	        
	        SearchBookRequest request = SearchBookRequest.newBuilder()
	                .setTopic(topic)
	                .build();

	        List<String> foundBooks = new ArrayList<>();
	        StreamObserver<SearchBookResponse> responseObserver = new StreamObserver<SearchBookResponse>() {
	            @Override
	            public void onNext(SearchBookResponse response) {
	                if (response.getSearchFinished()) {
	                    logger.info("Search was completed.");
	                    ReserveBook(scanner, asyncStub, foundBooks);
	                } else {
	                	foundBooks.add(response.getTitle());
	                    logger.info("Book found: " + response.getTitle() + " by " + response.getAuthor() +
	                            ", Description: " + response.getDescription() + ", Year: " + response.getYear());
	               
	                   // promptReservation(scanner, asyncStub, response.getTitle());  if i added here after found 1 book it asks if i want to reserver it, shows the next and asks, same action until it finishes the search
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

	//adding the reserve method of the books
	    private static void ReserveBook(Scanner scanner, Service3Grpc.Service3Stub asyncStub, List<String> foundBooks) {
	        if (foundBooks.isEmpty()) {
	            logger.info("No books found to reserve.");
	            return;
	        }

	        // Show all found books
	        System.out.println("\nFound books:");
	        for (int i = 0; i < foundBooks.size(); i++) {
	            System.out.println((i + 1) + ". " + foundBooks.get(i));
	        }

	        // Ask if the user wants to reserve a book
	        System.out.print("Would you like to reserve a book? (yes/no): ");
	        String response = scanner.nextLine();

	        if ("yes".equalsIgnoreCase(response)) {
	            System.out.print("Enter the title of the book you want to reserve: ");
	            String bookTitle = scanner.nextLine();

	            if (foundBooks.contains(bookTitle)) {
	                System.out.print("Enter your user ID: ");
	                String userId = scanner.nextLine();

	                StreamObserver<ReserveBookRequest> requestObserver = asyncStub.reserveBook(new StreamObserver<ReserveBookResponse>() {
	                    @Override
	                    public void onNext(ReserveBookResponse response) {
	                        logger.info("Reservation Confirmation Number: " + response.getConfirmationNumber());
	                        logger.info("Reservation Status: " + response.getStatus());
	                    }

	                    @Override
	                    public void onError(Throwable t) {
	                        logger.log(Level.SEVERE, "Reservation failed:", t);
	                    }

	                    @Override
	                    public void onCompleted() {
	                        logger.info("Reservation completed.");
	                    }
	                });

	                // Send the reservation request
	                ReserveBookRequest reserveRequest = ReserveBookRequest.newBuilder()
	                        .setBookId(bookTitle) // Assuming book title as ID for simplicity
	                        .setUserId(userId)
	                        .build();
	                requestObserver.onNext(reserveRequest);
	                
	                // Complete the request stream
	                requestObserver.onCompleted();
	            } else {
	                logger.info("Book title not found in the search results.");
	            }
	        } else {
	            logger.info("Reservation not made.");
	        }
	    }
	    
	}