package ds.service3;


	import java.util.ArrayList;
	import java.util.List;
	import java.util.Scanner;
	import java.util.concurrent.CountDownLatch;
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
	                    promptReservation(scanner, asyncStub, foundBooks);
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
	       // channel.shutdown().awaitTermination(1, TimeUnit.MINUTES);
	    }

	//adding the reserve method of the books
	    private static void promptReservation(Scanner scanner, Service3Grpc.Service3Stub asyncStub, List<String> foundBooks) {
	        if (foundBooks.isEmpty()) {
	            logger.info("No books found to reserve.");
	            return;
	        }
	        
	        List<String> booksToReserve = new ArrayList<>();
	        String userId = null;

	        // Show all found books
	        System.out.println("\nFound books:");
	        for (int i = 0; i < foundBooks.size(); i++) {
	            System.out.println((i + 1) + ". " + foundBooks.get(i));
	        }

	     // Ask if the user wants to reserve a book, I added loops and the condition to continue adding books if the user wants, until the answer is NO it will generate the confirmation of the reservation
	        for (int i = 0; i < foundBooks.size(); i++) {
	            String book = foundBooks.get(i);

	            System.out.print("Would you like to reserve book " + (i + 1) + ": " + book + "? (yes/no): "); //here Im printing the options to show to the user if she/he wants to reserve a book, going in order offering all the ones found
	            String response = scanner.nextLine();

	            if ("yes".equalsIgnoreCase(response)) {
	                booksToReserve.add(book);

	                if (userId == null) {
	                    System.out.print("Enter your user ID: ");
	                    userId = scanner.nextLine();
	                }
	            }

	            System.out.print("Would you like to check another book? (yes/no): ");
	            response = scanner.nextLine();

	            if (!"yes".equalsIgnoreCase(response)) {
	                break;
	            }
	        }

	        if (!booksToReserve.isEmpty()) {
	            CountDownLatch latch = new CountDownLatch(1);

	            StreamObserver<ReserveBookRequest> requestObserver = asyncStub.reserveBook(new StreamObserver<ReserveBookResponse>() {
	                @Override
	                public void onNext(ReserveBookResponse response) {
	                    logger.info("Reservation Confirmation Number: " + response.getConfirmationNumber());
	                    logger.info("Reservation Status: " + response.getStatus());
	                }

	                @Override
	                public void onError(Throwable t) {
	                    logger.log(Level.SEVERE, "Reservation failed:", t);
	                    latch.countDown();
	                }

	                @Override
	                public void onCompleted() {
	                    logger.info("Reservation completed.");
	                    latch.countDown();
	                }
	            });

	            for (String book : booksToReserve) {
	                ReserveBookRequest reserveRequest = ReserveBookRequest.newBuilder()
	                        .setBookId(book) //name of book
	                        .setUserId(userId)
	                        .build();
	                requestObserver.onNext(reserveRequest);
	            }

	            requestObserver.onCompleted();

	            try {
	                latch.await(1, TimeUnit.MINUTES);
	            } catch (InterruptedException e) {
	                logger.log(Level.SEVERE, "Reservation process interrupted:", e);
	            }
	        } else {
	            logger.info("No reservations made.");
	        }
	    }
	}