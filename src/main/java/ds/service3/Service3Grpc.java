package ds.service3;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.48.0)",
    comments = "Source: service3.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class Service3Grpc {

  private Service3Grpc() {}

  public static final String SERVICE_NAME = "Service3";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.service3.SearchBookRequest,
      ds.service3.SearchBookResponse> getSearchBookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "searchBook",
      requestType = ds.service3.SearchBookRequest.class,
      responseType = ds.service3.SearchBookResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.service3.SearchBookRequest,
      ds.service3.SearchBookResponse> getSearchBookMethod() {
    io.grpc.MethodDescriptor<ds.service3.SearchBookRequest, ds.service3.SearchBookResponse> getSearchBookMethod;
    if ((getSearchBookMethod = Service3Grpc.getSearchBookMethod) == null) {
      synchronized (Service3Grpc.class) {
        if ((getSearchBookMethod = Service3Grpc.getSearchBookMethod) == null) {
          Service3Grpc.getSearchBookMethod = getSearchBookMethod =
              io.grpc.MethodDescriptor.<ds.service3.SearchBookRequest, ds.service3.SearchBookResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "searchBook"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service3.SearchBookRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service3.SearchBookResponse.getDefaultInstance()))
              .setSchemaDescriptor(new Service3MethodDescriptorSupplier("searchBook"))
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
    if ((getReserveBookMethod = Service3Grpc.getReserveBookMethod) == null) {
      synchronized (Service3Grpc.class) {
        if ((getReserveBookMethod = Service3Grpc.getReserveBookMethod) == null) {
          Service3Grpc.getReserveBookMethod = getReserveBookMethod =
              io.grpc.MethodDescriptor.<ds.service3.ReserveBookRequest, ds.service3.ReserveBookResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReserveBook"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service3.ReserveBookRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service3.ReserveBookResponse.getDefaultInstance()))
              .setSchemaDescriptor(new Service3MethodDescriptorSupplier("ReserveBook"))
              .build();
        }
      }
    }
    return getReserveBookMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static Service3Stub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Service3Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<Service3Stub>() {
        @java.lang.Override
        public Service3Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new Service3Stub(channel, callOptions);
        }
      };
    return Service3Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static Service3BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Service3BlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<Service3BlockingStub>() {
        @java.lang.Override
        public Service3BlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new Service3BlockingStub(channel, callOptions);
        }
      };
    return Service3BlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static Service3FutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Service3FutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<Service3FutureStub>() {
        @java.lang.Override
        public Service3FutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new Service3FutureStub(channel, callOptions);
        }
      };
    return Service3FutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class Service3ImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Server Streaming RPC Searching books online by TOPIC
     * </pre>
     */
    public void searchBook(ds.service3.SearchBookRequest request,
        io.grpc.stub.StreamObserver<ds.service3.SearchBookResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSearchBookMethod(), responseObserver);
    }

    /**
     * <pre>
     * Client streaming RPC for Reserve books online .
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.service3.ReserveBookRequest> reserveBook(
        io.grpc.stub.StreamObserver<ds.service3.ReserveBookResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getReserveBookMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSearchBookMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                ds.service3.SearchBookRequest,
                ds.service3.SearchBookResponse>(
                  this, METHODID_SEARCH_BOOK)))
          .addMethod(
            getReserveBookMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                ds.service3.ReserveBookRequest,
                ds.service3.ReserveBookResponse>(
                  this, METHODID_RESERVE_BOOK)))
          .build();
    }
  }

  /**
   */
  public static final class Service3Stub extends io.grpc.stub.AbstractAsyncStub<Service3Stub> {
    private Service3Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Service3Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Service3Stub(channel, callOptions);
    }

    /**
     * <pre>
     * Server Streaming RPC Searching books online by TOPIC
     * </pre>
     */
    public void searchBook(ds.service3.SearchBookRequest request,
        io.grpc.stub.StreamObserver<ds.service3.SearchBookResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSearchBookMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Client streaming RPC for Reserve books online .
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.service3.ReserveBookRequest> reserveBook(
        io.grpc.stub.StreamObserver<ds.service3.ReserveBookResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getReserveBookMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class Service3BlockingStub extends io.grpc.stub.AbstractBlockingStub<Service3BlockingStub> {
    private Service3BlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Service3BlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Service3BlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Server Streaming RPC Searching books online by TOPIC
     * </pre>
     */
    public java.util.Iterator<ds.service3.SearchBookResponse> searchBook(
        ds.service3.SearchBookRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSearchBookMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class Service3FutureStub extends io.grpc.stub.AbstractFutureStub<Service3FutureStub> {
    private Service3FutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Service3FutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Service3FutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SEARCH_BOOK = 0;
  private static final int METHODID_RESERVE_BOOK = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final Service3ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(Service3ImplBase serviceImpl, int methodId) {
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

  private static abstract class Service3BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    Service3BaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.service3.Service3Impl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Service3");
    }
  }

  private static final class Service3FileDescriptorSupplier
      extends Service3BaseDescriptorSupplier {
    Service3FileDescriptorSupplier() {}
  }

  private static final class Service3MethodDescriptorSupplier
      extends Service3BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    Service3MethodDescriptorSupplier(String methodName) {
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
      synchronized (Service3Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new Service3FileDescriptorSupplier())
              .addMethod(getSearchBookMethod())
              .addMethod(getReserveBookMethod())
              .build();
        }
      }
    }
    return result;
  }
}
