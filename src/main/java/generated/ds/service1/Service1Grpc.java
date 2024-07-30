package generated.ds.service1;

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
 * <pre>
 * Air Conditioning service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: service1.proto")
public final class Service1Grpc {

  private Service1Grpc() {}

  public static final String SERVICE_NAME = "service1.Service1";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.ds.service1.ControlRequest,
      generated.ds.service1.ControlResponse> getControlTemperatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "controlTemperature",
      requestType = generated.ds.service1.ControlRequest.class,
      responseType = generated.ds.service1.ControlResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<generated.ds.service1.ControlRequest,
      generated.ds.service1.ControlResponse> getControlTemperatureMethod() {
    io.grpc.MethodDescriptor<generated.ds.service1.ControlRequest, generated.ds.service1.ControlResponse> getControlTemperatureMethod;
    if ((getControlTemperatureMethod = Service1Grpc.getControlTemperatureMethod) == null) {
      synchronized (Service1Grpc.class) {
        if ((getControlTemperatureMethod = Service1Grpc.getControlTemperatureMethod) == null) {
          Service1Grpc.getControlTemperatureMethod = getControlTemperatureMethod = 
              io.grpc.MethodDescriptor.<generated.ds.service1.ControlRequest, generated.ds.service1.ControlResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "service1.Service1", "controlTemperature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.ds.service1.ControlRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.ds.service1.ControlResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new Service1MethodDescriptorSupplier("controlTemperature"))
                  .build();
          }
        }
     }
     return getControlTemperatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.ds.service1.LightRequest,
      generated.ds.service1.LightResponse> getControlLightsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ControlLights",
      requestType = generated.ds.service1.LightRequest.class,
      responseType = generated.ds.service1.LightResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.ds.service1.LightRequest,
      generated.ds.service1.LightResponse> getControlLightsMethod() {
    io.grpc.MethodDescriptor<generated.ds.service1.LightRequest, generated.ds.service1.LightResponse> getControlLightsMethod;
    if ((getControlLightsMethod = Service1Grpc.getControlLightsMethod) == null) {
      synchronized (Service1Grpc.class) {
        if ((getControlLightsMethod = Service1Grpc.getControlLightsMethod) == null) {
          Service1Grpc.getControlLightsMethod = getControlLightsMethod = 
              io.grpc.MethodDescriptor.<generated.ds.service1.LightRequest, generated.ds.service1.LightResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "service1.Service1", "ControlLights"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.ds.service1.LightRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.ds.service1.LightResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new Service1MethodDescriptorSupplier("ControlLights"))
                  .build();
          }
        }
     }
     return getControlLightsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static Service1Stub newStub(io.grpc.Channel channel) {
    return new Service1Stub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static Service1BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new Service1BlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static Service1FutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new Service1FutureStub(channel);
  }

  /**
   * <pre>
   * Air Conditioning service definition.
   * </pre>
   */
  public static abstract class Service1ImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Bidirectional streaming RPC for control the temperature.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<generated.ds.service1.ControlRequest> controlTemperature(
        io.grpc.stub.StreamObserver<generated.ds.service1.ControlResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getControlTemperatureMethod(), responseObserver);
    }

    /**
     * <pre>
     * Unary RPC for turning lights on and off.
     * </pre>
     */
    public void controlLights(generated.ds.service1.LightRequest request,
        io.grpc.stub.StreamObserver<generated.ds.service1.LightResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getControlLightsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getControlTemperatureMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                generated.ds.service1.ControlRequest,
                generated.ds.service1.ControlResponse>(
                  this, METHODID_CONTROL_TEMPERATURE)))
          .addMethod(
            getControlLightsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.ds.service1.LightRequest,
                generated.ds.service1.LightResponse>(
                  this, METHODID_CONTROL_LIGHTS)))
          .build();
    }
  }

  /**
   * <pre>
   * Air Conditioning service definition.
   * </pre>
   */
  public static final class Service1Stub extends io.grpc.stub.AbstractStub<Service1Stub> {
    private Service1Stub(io.grpc.Channel channel) {
      super(channel);
    }

    private Service1Stub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Service1Stub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Service1Stub(channel, callOptions);
    }

    /**
     * <pre>
     * Bidirectional streaming RPC for control the temperature.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<generated.ds.service1.ControlRequest> controlTemperature(
        io.grpc.stub.StreamObserver<generated.ds.service1.ControlResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getControlTemperatureMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Unary RPC for turning lights on and off.
     * </pre>
     */
    public void controlLights(generated.ds.service1.LightRequest request,
        io.grpc.stub.StreamObserver<generated.ds.service1.LightResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getControlLightsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Air Conditioning service definition.
   * </pre>
   */
  public static final class Service1BlockingStub extends io.grpc.stub.AbstractStub<Service1BlockingStub> {
    private Service1BlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Service1BlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Service1BlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Service1BlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC for turning lights on and off.
     * </pre>
     */
    public generated.ds.service1.LightResponse controlLights(generated.ds.service1.LightRequest request) {
      return blockingUnaryCall(
          getChannel(), getControlLightsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Air Conditioning service definition.
   * </pre>
   */
  public static final class Service1FutureStub extends io.grpc.stub.AbstractStub<Service1FutureStub> {
    private Service1FutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Service1FutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Service1FutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Service1FutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC for turning lights on and off.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.ds.service1.LightResponse> controlLights(
        generated.ds.service1.LightRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getControlLightsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CONTROL_LIGHTS = 0;
  private static final int METHODID_CONTROL_TEMPERATURE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final Service1ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(Service1ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CONTROL_LIGHTS:
          serviceImpl.controlLights((generated.ds.service1.LightRequest) request,
              (io.grpc.stub.StreamObserver<generated.ds.service1.LightResponse>) responseObserver);
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
        case METHODID_CONTROL_TEMPERATURE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.controlTemperature(
              (io.grpc.stub.StreamObserver<generated.ds.service1.ControlResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class Service1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    Service1BaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.ds.service1.Service1Impl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Service1");
    }
  }

  private static final class Service1FileDescriptorSupplier
      extends Service1BaseDescriptorSupplier {
    Service1FileDescriptorSupplier() {}
  }

  private static final class Service1MethodDescriptorSupplier
      extends Service1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    Service1MethodDescriptorSupplier(String methodName) {
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
      synchronized (Service1Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new Service1FileDescriptorSupplier())
              .addMethod(getControlTemperatureMethod())
              .addMethod(getControlLightsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
