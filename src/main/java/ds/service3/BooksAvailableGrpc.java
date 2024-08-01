package ds.service3;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: service3.proto")
public final class BooksAvailableGrpc {

  private BooksAvailableGrpc() {}

  public static final String SERVICE_NAME = "BooksAvailable";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.service3.SearchBookRequest,
      ds.service3.SearchBookResponse> getSearchBookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchBook",
      requestType = ds.service3.SearchBookRequest.class,
      responseType = ds.service3.SearchBookResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.service3.SearchBookRequest,
      ds.service3.SearchBookResponse> getSearchBookMethod() {
    io.grpc.MethodDescriptor<ds.service3.SearchBookRequest, ds.service3.SearchBookResponse> getSearchBookMethod;
    if ((getSearchBookMethod = BooksAvailableGrpc.getSearchBookMethod) == null) {
      synchronized (BooksAvailableGrpc.class) {
        if ((getSearchBookMethod = BooksAvailableGrpc.getSearchBookMethod) == null) {
          BooksAvailableGrpc.getSearchBookMethod = getSearchBookMethod = 
              io.grpc.MethodDescriptor.<ds.service3.SearchBookRequest, ds.service3.SearchBookResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "BooksAvailable", "SearchBook"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service3.SearchBookRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service3.SearchBookResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BooksAvailableMethodDescriptorSupplier("SearchBook"))
                  .build();
          }
        }
     }
     return getSearchBookMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.service3.ReserveBookRequest,
      ds.service3.ReserveBookResponse> getReserveBookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReserveBook",
      requestType = ds.service3.ReserveBookRequest.class,
      responseType = ds.service3.ReserveBookResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ds.service3.ReserveBookRequest,
      ds.service3.ReserveBookResponse> getReserveBookMethod() {
    io.grpc.MethodDescriptor<ds.service3.ReserveBookRequest, ds.service3.ReserveBookResponse> getReserveBookMethod;
    if ((getReserveBookMethod = BooksAvailableGrpc.getReserveBookMethod) == null) {
      synchronized (BooksAvailableGrpc.class) {
        if ((getReserveBookMethod = BooksAvailableGrpc.getReserveBookMethod) == null) {
          BooksAvailableGrpc.getReserveBookMethod = getReserveBookMethod = 
              io.grpc.MethodDescriptor.<ds.service3.ReserveBookRequest, ds.service3.ReserveBookResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "BooksAvailable", "ReserveBook"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service3.ReserveBookRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service3.ReserveBookResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BooksAvailableMethodDescriptorSupplier("ReserveBook"))
                  .build();
          }
        }
     }
     return getReserveBookMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BooksAvailableStub newStub(io.grpc.Channel channel) {
    return new BooksAvailableStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BooksAvailableBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BooksAvailableBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BooksAvailableFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BooksAvailableFutureStub(channel);
  }

  /**
   */
  public static abstract class BooksAvailableImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Server Streaming RPC Searching books online by TOPIC
     * </pre>
     */
    public void searchBook(ds.service3.SearchBookRequest request,
        io.grpc.stub.StreamObserver<ds.service3.SearchBookResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSearchBookMethod(), responseObserver);
    }

    /**
     * <pre>
     * Client streaming RPC for Reserve books online .
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.service3.ReserveBookRequest> reserveBook(
        io.grpc.stub.StreamObserver<ds.service3.ReserveBookResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getReserveBookMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSearchBookMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.service3.SearchBookRequest,
                ds.service3.SearchBookResponse>(
                  this, METHODID_SEARCH_BOOK)))
          .addMethod(
            getReserveBookMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                ds.service3.ReserveBookRequest,
                ds.service3.ReserveBookResponse>(
                  this, METHODID_RESERVE_BOOK)))
          .build();
    }
  }

  /**
   */
  public static final class BooksAvailableStub extends io.grpc.stub.AbstractStub<BooksAvailableStub> {
    private BooksAvailableStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BooksAvailableStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BooksAvailableStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BooksAvailableStub(channel, callOptions);
    }

    /**
     * <pre>
     * Server Streaming RPC Searching books online by TOPIC
     * </pre>
     */
    public void searchBook(ds.service3.SearchBookRequest request,
        io.grpc.stub.StreamObserver<ds.service3.SearchBookResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSearchBookMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Client streaming RPC for Reserve books online .
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.service3.ReserveBookRequest> reserveBook(
        io.grpc.stub.StreamObserver<ds.service3.ReserveBookResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getReserveBookMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class BooksAvailableBlockingStub extends io.grpc.stub.AbstractStub<BooksAvailableBlockingStub> {
    private BooksAvailableBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BooksAvailableBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BooksAvailableBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BooksAvailableBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Server Streaming RPC Searching books online by TOPIC
     * </pre>
     */
    public java.util.Iterator<ds.service3.SearchBookResponse> searchBook(
        ds.service3.SearchBookRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getSearchBookMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BooksAvailableFutureStub extends io.grpc.stub.AbstractStub<BooksAvailableFutureStub> {
    private BooksAvailableFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BooksAvailableFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BooksAvailableFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BooksAvailableFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SEARCH_BOOK = 0;
  private static final int METHODID_RESERVE_BOOK = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BooksAvailableImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BooksAvailableImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEARCH_BOOK:
          serviceImpl.searchBook((ds.service3.SearchBookRequest) request,
              (io.grpc.stub.StreamObserver<ds.service3.SearchBookResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RESERVE_BOOK:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.reserveBook(
              (io.grpc.stub.StreamObserver<ds.service3.ReserveBookResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class BooksAvailableBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BooksAvailableBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.service3.Service3Impl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BooksAvailable");
    }
  }

  private static final class BooksAvailableFileDescriptorSupplier
      extends BooksAvailableBaseDescriptorSupplier {
    BooksAvailableFileDescriptorSupplier() {}
  }

  private static final class BooksAvailableMethodDescriptorSupplier
      extends BooksAvailableBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BooksAvailableMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (BooksAvailableGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BooksAvailableFileDescriptorSupplier())
              .addMethod(getSearchBookMethod())
              .addMethod(getReserveBookMethod())
              .build();
        }
      }
    }
    return result;
  }
}
