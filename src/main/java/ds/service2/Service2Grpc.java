package ds.service2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.48.0)",
    comments = "Source: service2.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class Service2Grpc {

  private Service2Grpc() {}

  public static final String SERVICE_NAME = "service2.Service2";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.service2.LogInRequest,
      ds.service2.LogInResponse> getLogInMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LogIn",
      requestType = ds.service2.LogInRequest.class,
      responseType = ds.service2.LogInResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.service2.LogInRequest,
      ds.service2.LogInResponse> getLogInMethod() {
    io.grpc.MethodDescriptor<ds.service2.LogInRequest, ds.service2.LogInResponse> getLogInMethod;
    if ((getLogInMethod = Service2Grpc.getLogInMethod) == null) {
      synchronized (Service2Grpc.class) {
        if ((getLogInMethod = Service2Grpc.getLogInMethod) == null) {
          Service2Grpc.getLogInMethod = getLogInMethod =
              io.grpc.MethodDescriptor.<ds.service2.LogInRequest, ds.service2.LogInResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LogIn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service2.LogInRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service2.LogInResponse.getDefaultInstance()))
              .setSchemaDescriptor(new Service2MethodDescriptorSupplier("LogIn"))
              .build();
        }
      }
    }
    return getLogInMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.service2.updateProfileRequest,
      ds.service2.updateProfileResponse> getUpdateProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateProfile",
      requestType = ds.service2.updateProfileRequest.class,
      responseType = ds.service2.updateProfileResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ds.service2.updateProfileRequest,
      ds.service2.updateProfileResponse> getUpdateProfileMethod() {
    io.grpc.MethodDescriptor<ds.service2.updateProfileRequest, ds.service2.updateProfileResponse> getUpdateProfileMethod;
    if ((getUpdateProfileMethod = Service2Grpc.getUpdateProfileMethod) == null) {
      synchronized (Service2Grpc.class) {
        if ((getUpdateProfileMethod = Service2Grpc.getUpdateProfileMethod) == null) {
          Service2Grpc.getUpdateProfileMethod = getUpdateProfileMethod =
              io.grpc.MethodDescriptor.<ds.service2.updateProfileRequest, ds.service2.updateProfileResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateProfile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service2.updateProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service2.updateProfileResponse.getDefaultInstance()))
              .setSchemaDescriptor(new Service2MethodDescriptorSupplier("updateProfile"))
              .build();
        }
      }
    }
    return getUpdateProfileMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static Service2Stub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Service2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<Service2Stub>() {
        @java.lang.Override
        public Service2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new Service2Stub(channel, callOptions);
        }
      };
    return Service2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static Service2BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Service2BlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<Service2BlockingStub>() {
        @java.lang.Override
        public Service2BlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new Service2BlockingStub(channel, callOptions);
        }
      };
    return Service2BlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static Service2FutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Service2FutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<Service2FutureStub>() {
        @java.lang.Override
        public Service2FutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new Service2FutureStub(channel, callOptions);
        }
      };
    return Service2FutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class Service2ImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Unary RPC to Log In.
     * </pre>
     */
    public void logIn(ds.service2.LogInRequest request,
        io.grpc.stub.StreamObserver<ds.service2.LogInResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLogInMethod(), responseObserver);
    }

    /**
     * <pre>
     * Client streaming RPC for Update profile information.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.service2.updateProfileRequest> updateProfile(
        io.grpc.stub.StreamObserver<ds.service2.updateProfileResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getUpdateProfileMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLogInMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ds.service2.LogInRequest,
                ds.service2.LogInResponse>(
                  this, METHODID_LOG_IN)))
          .addMethod(
            getUpdateProfileMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                ds.service2.updateProfileRequest,
                ds.service2.updateProfileResponse>(
                  this, METHODID_UPDATE_PROFILE)))
          .build();
    }
  }

  /**
   */
  public static final class Service2Stub extends io.grpc.stub.AbstractAsyncStub<Service2Stub> {
    private Service2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Service2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Service2Stub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC to Log In.
     * </pre>
     */
    public void logIn(ds.service2.LogInRequest request,
        io.grpc.stub.StreamObserver<ds.service2.LogInResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLogInMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Client streaming RPC for Update profile information.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.service2.updateProfileRequest> updateProfile(
        io.grpc.stub.StreamObserver<ds.service2.updateProfileResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getUpdateProfileMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class Service2BlockingStub extends io.grpc.stub.AbstractBlockingStub<Service2BlockingStub> {
    private Service2BlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Service2BlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Service2BlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC to Log In.
     * </pre>
     */
    public ds.service2.LogInResponse logIn(ds.service2.LogInRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLogInMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class Service2FutureStub extends io.grpc.stub.AbstractFutureStub<Service2FutureStub> {
    private Service2FutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Service2FutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Service2FutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC to Log In.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.service2.LogInResponse> logIn(
        ds.service2.LogInRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLogInMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOG_IN = 0;
  private static final int METHODID_UPDATE_PROFILE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final Service2ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(Service2ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOG_IN:
          serviceImpl.logIn((ds.service2.LogInRequest) request,
              (io.grpc.stub.StreamObserver<ds.service2.LogInResponse>) responseObserver);
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
        case METHODID_UPDATE_PROFILE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.updateProfile(
              (io.grpc.stub.StreamObserver<ds.service2.updateProfileResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class Service2BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    Service2BaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.service2.Service2Impl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Service2");
    }
  }

  private static final class Service2FileDescriptorSupplier
      extends Service2BaseDescriptorSupplier {
    Service2FileDescriptorSupplier() {}
  }

  private static final class Service2MethodDescriptorSupplier
      extends Service2BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    Service2MethodDescriptorSupplier(String methodName) {
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
      synchronized (Service2Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new Service2FileDescriptorSupplier())
              .addMethod(getLogInMethod())
              .addMethod(getUpdateProfileMethod())
              .build();
        }
      }
    }
    return result;
  }
}
