package ds.service3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


import ds.service3.Service3Grpc.Service3ImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

	


	public class Service3 extends Service3ImplBase{



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
	}