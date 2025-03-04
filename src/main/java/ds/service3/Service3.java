package ds.service3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


import ds.service3.Service3Grpc.Service3ImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

	
	public class Service3 extends Service3ImplBase{
		 private Server server;

		    public void startMe() {
		        try {
		            int port = 50053;
		            server = ServerBuilder.forPort(port)
		                    .addService(this)
		                    .build()
		                    .start();
		            System.out.println("Service-3 started, listening on " + port);
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }

		    public void stopMe() {
		        if (server != null) {
		            server.shutdown();
		        }
		    }
		
		
		
		private int reservationCounter = 1;
		
		public static void main(String[] args) throws InterruptedException, IOException {
			Service3 service3 = new Service3();

			int port = 50053;

			Server server = ServerBuilder.forPort(port)
					.addService(service3)
					.build()
					.start();

			System.out.println("Service-3 started, listening on " + port);

			server.awaitTermination();
		}

	
	//ADDING HERE MY FIRST METHOD TO SEARCH BOOKS GIVING A WORD
		//@Override
	    public void searchBook(SearchBookRequest request, StreamObserver<SearchBookResponse> responseObserver) {
	        String topic = request.getTopic();
	        System.out.println("Received request to search for topic: " + topic);
	        
	        // Creating a list with the books
	        List<SearchBookResponse> bookResponses = SearchBooksByTopic(topic);

	        for (SearchBookResponse response : bookResponses) {
	            responseObserver.onNext(response);
	            try {
	                // small pause time to simulate processing time
	                TimeUnit.SECONDS.sleep(1);
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	                responseObserver.onError(e);
	                return;
	            }
	        }

	        // Give a message when a search has finished
	        SearchBookResponse endResponse = SearchBookResponse.newBuilder().setSearchFinished(true).build();
	        responseObserver.onNext(endResponse);
	        responseObserver.onCompleted();
	    }
	    // METHOD  to search books, with dummie information for testing my code
	    private List<SearchBookResponse> SearchBooksByTopic(String topic) {
	        // list with the information of the books
	        List<SearchBookResponse> responses = new ArrayList<>();

	        // example of books that will appear if the Topic is found
	        if (topic.equalsIgnoreCase("Science")) {
	            responses.add(createBookResponse("Science Book 1", "Author 1", "Description 1", 1990));
	            responses.add(createBookResponse("Science Book 2", "Author 2", "Description 2", 1992));
	            responses.add(createBookResponse("Science Book 3", "Author 3", "Description 3", 1993));
	            responses.add(createBookResponse("Science Book 4", "Author 4", "Description 4", 1994));
	            responses.add(createBookResponse("Science Book 5", "Author 5", "Description 5", 1995));
	        } else if (topic.equalsIgnoreCase("Thriller")) {
	        	 responses.add(createBookResponse("Thriller Book 1", "Author 1", "Description 1", 1990));
		         responses.add(createBookResponse("Thriller Book 2", "Author 2", "Description 2", 1992));
		         responses.add(createBookResponse("Thriller Book 3", "Author 3", "Description 3", 1993));
		         responses.add(createBookResponse("Thriller Book 4", "Author 4", "Description 4", 1994));
		         responses.add(createBookResponse("Thriller Book 5", "Author 5", "Description 5", 1995));   
	        } else if (topic.equalsIgnoreCase("Fiction")) {
	            responses.add(createBookResponse("Fiction Book 1", "Author 1", "Description 1", 1990));
	            responses.add(createBookResponse("Fiction Book 2", "Author 2", "Description 2", 1992));
	            responses.add(createBookResponse("Fiction Book 3", "Author 3", "Description 3", 1993));
	            responses.add(createBookResponse("Fiction Book 4", "Author 4", "Description 4", 1994));
	            responses.add(createBookResponse("Fiction Book 5", "Author 5", "Description 5", 1995));
	        } else if (topic.equalsIgnoreCase("Literature")) {
	            responses.add(createBookResponse("Literature Book 1", "Author 1", "Description 1", 1990));
	            responses.add(createBookResponse("Literature Book 2", "Author 2", "Description 2", 1992));
	            responses.add(createBookResponse("Literature Book 3", "Author 3", "Description 3", 1993));
	            responses.add(createBookResponse("Literature Book 4", "Author 4", "Description 4", 1994));
	            responses.add(createBookResponse("Literature Book 5", "Author 5", "Description 5", 1995));
	        } 	

	        return responses;
	    }

	    // Method to give a response with all the attributes of a book
	    private SearchBookResponse createBookResponse(String title, String author, String description, int year) {
	        return SearchBookResponse.newBuilder()
	                .setTitle(title)
	                .setAuthor(author)
	                .setDescription(description)
	                .setYear(year)
	                .setSearchFinished(false)
	                .build();
	    }
	    
	    // MY METHOD  to RESERVE books, using the books I defined above to test (in real life I should have a database to search and to reserve from there)
	    @Override
	    public StreamObserver<ReserveBookRequest> reserveBook(StreamObserver<ReserveBookResponse> responseObserver) {
	        return new StreamObserver<ReserveBookRequest>() {
	        	private List<String> reservedBooks = new ArrayList<>();
	            private String userId;
	        	
	            @Override
	            public void onNext(ReserveBookRequest request) {
	                String bookId = request.getBookId();
	                userId = request.getUserId();
	              //  int reservationCounter = 1;
	                
	                
	             // Simulate reservation process
	             //   int currentReservationNumber = reservationCounter++; // Increment reservation counter
	            //    String confirmationNumber = "NoConfirmation." + currentReservationNumber;
	            //    String status = "Reserved";

	                reservedBooks.add(bookId);
	                System.out.println("Received reservation request for Book ID: " + bookId + ", User ID: " + userId);

	             // Ask if the user wants to reserve another book
	                System.out.println("Do you want to reserve another book? (yes/no): ");
	                Scanner scanner = new Scanner(System.in);
	                String response = scanner.nextLine();

	                //added the condition, this is to asks to add more books in the reservation and proceed with an action depending on the answer
	                if (!"yes".equalsIgnoreCase(response)) {
	                    int currentReservationNumber = reservationCounter++;
	                    String confirmationNumber = "NoConfirmation." + currentReservationNumber;
	                    String status = "Reserved";
	                
	                
	                ReserveBookResponse reserveResponse = ReserveBookResponse.newBuilder()
	                        .setConfirmationNumber(confirmationNumber)
	                        .setStatus(status)
	                        .build();

	                responseObserver.onNext(reserveResponse);//had to added it to correct the code
	                responseObserver.onCompleted();
	            }
	           }

	            @Override
	            public void onError(Throwable t) {
	                System.err.println("Reservation error: " + t.getMessage());
	            }

	            @Override
	            public void onCompleted() {
	                responseObserver.onCompleted();
	            }
	        };
	    }
	    
	}