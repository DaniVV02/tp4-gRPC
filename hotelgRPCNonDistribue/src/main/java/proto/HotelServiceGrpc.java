package proto;

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
    comments = "Source: hotel.proto")
public final class HotelServiceGrpc {

  private HotelServiceGrpc() {}

  public static final String SERVICE_NAME = "HotelService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.HotelOuterClass.SearchRequest,
      proto.HotelOuterClass.SearchResponse> getSearchHotelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchHotels",
      requestType = proto.HotelOuterClass.SearchRequest.class,
      responseType = proto.HotelOuterClass.SearchResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.HotelOuterClass.SearchRequest,
      proto.HotelOuterClass.SearchResponse> getSearchHotelsMethod() {
    io.grpc.MethodDescriptor<proto.HotelOuterClass.SearchRequest, proto.HotelOuterClass.SearchResponse> getSearchHotelsMethod;
    if ((getSearchHotelsMethod = HotelServiceGrpc.getSearchHotelsMethod) == null) {
      synchronized (HotelServiceGrpc.class) {
        if ((getSearchHotelsMethod = HotelServiceGrpc.getSearchHotelsMethod) == null) {
          HotelServiceGrpc.getSearchHotelsMethod = getSearchHotelsMethod = 
              io.grpc.MethodDescriptor.<proto.HotelOuterClass.SearchRequest, proto.HotelOuterClass.SearchResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "HotelService", "SearchHotels"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.HotelOuterClass.SearchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.HotelOuterClass.SearchResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HotelServiceMethodDescriptorSupplier("SearchHotels"))
                  .build();
          }
        }
     }
     return getSearchHotelsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.HotelOuterClass.ReservationRequest,
      proto.HotelOuterClass.ReservationResponse> getMakeReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MakeReservation",
      requestType = proto.HotelOuterClass.ReservationRequest.class,
      responseType = proto.HotelOuterClass.ReservationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.HotelOuterClass.ReservationRequest,
      proto.HotelOuterClass.ReservationResponse> getMakeReservationMethod() {
    io.grpc.MethodDescriptor<proto.HotelOuterClass.ReservationRequest, proto.HotelOuterClass.ReservationResponse> getMakeReservationMethod;
    if ((getMakeReservationMethod = HotelServiceGrpc.getMakeReservationMethod) == null) {
      synchronized (HotelServiceGrpc.class) {
        if ((getMakeReservationMethod = HotelServiceGrpc.getMakeReservationMethod) == null) {
          HotelServiceGrpc.getMakeReservationMethod = getMakeReservationMethod = 
              io.grpc.MethodDescriptor.<proto.HotelOuterClass.ReservationRequest, proto.HotelOuterClass.ReservationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "HotelService", "MakeReservation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.HotelOuterClass.ReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.HotelOuterClass.ReservationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HotelServiceMethodDescriptorSupplier("MakeReservation"))
                  .build();
          }
        }
     }
     return getMakeReservationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HotelServiceStub newStub(io.grpc.Channel channel) {
    return new HotelServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HotelServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new HotelServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HotelServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new HotelServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class HotelServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void searchHotels(proto.HotelOuterClass.SearchRequest request,
        io.grpc.stub.StreamObserver<proto.HotelOuterClass.SearchResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSearchHotelsMethod(), responseObserver);
    }

    /**
     */
    public void makeReservation(proto.HotelOuterClass.ReservationRequest request,
        io.grpc.stub.StreamObserver<proto.HotelOuterClass.ReservationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getMakeReservationMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSearchHotelsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proto.HotelOuterClass.SearchRequest,
                proto.HotelOuterClass.SearchResponse>(
                  this, METHODID_SEARCH_HOTELS)))
          .addMethod(
            getMakeReservationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proto.HotelOuterClass.ReservationRequest,
                proto.HotelOuterClass.ReservationResponse>(
                  this, METHODID_MAKE_RESERVATION)))
          .build();
    }
  }

  /**
   */
  public static final class HotelServiceStub extends io.grpc.stub.AbstractStub<HotelServiceStub> {
    private HotelServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HotelServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HotelServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HotelServiceStub(channel, callOptions);
    }

    /**
     */
    public void searchHotels(proto.HotelOuterClass.SearchRequest request,
        io.grpc.stub.StreamObserver<proto.HotelOuterClass.SearchResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSearchHotelsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void makeReservation(proto.HotelOuterClass.ReservationRequest request,
        io.grpc.stub.StreamObserver<proto.HotelOuterClass.ReservationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMakeReservationMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class HotelServiceBlockingStub extends io.grpc.stub.AbstractStub<HotelServiceBlockingStub> {
    private HotelServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HotelServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HotelServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HotelServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.HotelOuterClass.SearchResponse searchHotels(proto.HotelOuterClass.SearchRequest request) {
      return blockingUnaryCall(
          getChannel(), getSearchHotelsMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.HotelOuterClass.ReservationResponse makeReservation(proto.HotelOuterClass.ReservationRequest request) {
      return blockingUnaryCall(
          getChannel(), getMakeReservationMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class HotelServiceFutureStub extends io.grpc.stub.AbstractStub<HotelServiceFutureStub> {
    private HotelServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HotelServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HotelServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HotelServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.HotelOuterClass.SearchResponse> searchHotels(
        proto.HotelOuterClass.SearchRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSearchHotelsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.HotelOuterClass.ReservationResponse> makeReservation(
        proto.HotelOuterClass.ReservationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getMakeReservationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEARCH_HOTELS = 0;
  private static final int METHODID_MAKE_RESERVATION = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HotelServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HotelServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEARCH_HOTELS:
          serviceImpl.searchHotels((proto.HotelOuterClass.SearchRequest) request,
              (io.grpc.stub.StreamObserver<proto.HotelOuterClass.SearchResponse>) responseObserver);
          break;
        case METHODID_MAKE_RESERVATION:
          serviceImpl.makeReservation((proto.HotelOuterClass.ReservationRequest) request,
              (io.grpc.stub.StreamObserver<proto.HotelOuterClass.ReservationResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class HotelServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HotelServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.HotelOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HotelService");
    }
  }

  private static final class HotelServiceFileDescriptorSupplier
      extends HotelServiceBaseDescriptorSupplier {
    HotelServiceFileDescriptorSupplier() {}
  }

  private static final class HotelServiceMethodDescriptorSupplier
      extends HotelServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HotelServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (HotelServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HotelServiceFileDescriptorSupplier())
              .addMethod(getSearchHotelsMethod())
              .addMethod(getMakeReservationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
