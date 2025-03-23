package com.szhuima.zim.api.proto.msg;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.71.0)",
    comments = "Source: Msg.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MsgServiceGrpc {

  private MsgServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "MsgService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.szhuima.zim.api.proto.msg.MsgProto.MsgRequest,
      com.szhuima.zim.api.proto.msg.MsgProto.MsgResponse> getSendMsgMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendMsg",
      requestType = com.szhuima.zim.api.proto.msg.MsgProto.MsgRequest.class,
      responseType = com.szhuima.zim.api.proto.msg.MsgProto.MsgResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.szhuima.zim.api.proto.msg.MsgProto.MsgRequest,
      com.szhuima.zim.api.proto.msg.MsgProto.MsgResponse> getSendMsgMethod() {
    io.grpc.MethodDescriptor<com.szhuima.zim.api.proto.msg.MsgProto.MsgRequest, com.szhuima.zim.api.proto.msg.MsgProto.MsgResponse> getSendMsgMethod;
    if ((getSendMsgMethod = MsgServiceGrpc.getSendMsgMethod) == null) {
      synchronized (MsgServiceGrpc.class) {
        if ((getSendMsgMethod = MsgServiceGrpc.getSendMsgMethod) == null) {
          MsgServiceGrpc.getSendMsgMethod = getSendMsgMethod =
              io.grpc.MethodDescriptor.<com.szhuima.zim.api.proto.msg.MsgProto.MsgRequest, com.szhuima.zim.api.proto.msg.MsgProto.MsgResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sendMsg"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.szhuima.zim.api.proto.msg.MsgProto.MsgRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.szhuima.zim.api.proto.msg.MsgProto.MsgResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MsgServiceMethodDescriptorSupplier("sendMsg"))
              .build();
        }
      }
    }
    return getSendMsgMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.szhuima.zim.api.proto.msg.MsgProto.MsgRequest,
      com.szhuima.zim.api.proto.msg.MsgProto.MsgResponse> getSendMsgAsyncMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendMsgAsync",
      requestType = com.szhuima.zim.api.proto.msg.MsgProto.MsgRequest.class,
      responseType = com.szhuima.zim.api.proto.msg.MsgProto.MsgResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.szhuima.zim.api.proto.msg.MsgProto.MsgRequest,
      com.szhuima.zim.api.proto.msg.MsgProto.MsgResponse> getSendMsgAsyncMethod() {
    io.grpc.MethodDescriptor<com.szhuima.zim.api.proto.msg.MsgProto.MsgRequest, com.szhuima.zim.api.proto.msg.MsgProto.MsgResponse> getSendMsgAsyncMethod;
    if ((getSendMsgAsyncMethod = MsgServiceGrpc.getSendMsgAsyncMethod) == null) {
      synchronized (MsgServiceGrpc.class) {
        if ((getSendMsgAsyncMethod = MsgServiceGrpc.getSendMsgAsyncMethod) == null) {
          MsgServiceGrpc.getSendMsgAsyncMethod = getSendMsgAsyncMethod =
              io.grpc.MethodDescriptor.<com.szhuima.zim.api.proto.msg.MsgProto.MsgRequest, com.szhuima.zim.api.proto.msg.MsgProto.MsgResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sendMsgAsync"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.szhuima.zim.api.proto.msg.MsgProto.MsgRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.szhuima.zim.api.proto.msg.MsgProto.MsgResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MsgServiceMethodDescriptorSupplier("sendMsgAsync"))
              .build();
        }
      }
    }
    return getSendMsgAsyncMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MsgServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MsgServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MsgServiceStub>() {
        @java.lang.Override
        public MsgServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MsgServiceStub(channel, callOptions);
        }
      };
    return MsgServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static MsgServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MsgServiceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MsgServiceBlockingV2Stub>() {
        @java.lang.Override
        public MsgServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MsgServiceBlockingV2Stub(channel, callOptions);
        }
      };
    return MsgServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MsgServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MsgServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MsgServiceBlockingStub>() {
        @java.lang.Override
        public MsgServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MsgServiceBlockingStub(channel, callOptions);
        }
      };
    return MsgServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MsgServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MsgServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MsgServiceFutureStub>() {
        @java.lang.Override
        public MsgServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MsgServiceFutureStub(channel, callOptions);
        }
      };
    return MsgServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * 阻塞发送消息
     * </pre>
     */
    default void sendMsg(com.szhuima.zim.api.proto.msg.MsgProto.MsgRequest request,
        io.grpc.stub.StreamObserver<com.szhuima.zim.api.proto.msg.MsgProto.MsgResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendMsgMethod(), responseObserver);
    }

    /**
     * <pre>
     * 异步发送消息
     * </pre>
     */
    default void sendMsgAsync(com.szhuima.zim.api.proto.msg.MsgProto.MsgRequest request,
        io.grpc.stub.StreamObserver<com.szhuima.zim.api.proto.msg.MsgProto.MsgResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendMsgAsyncMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service MsgService.
   */
  public static abstract class MsgServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return MsgServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service MsgService.
   */
  public static final class MsgServiceStub
      extends io.grpc.stub.AbstractAsyncStub<MsgServiceStub> {
    private MsgServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MsgServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MsgServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 阻塞发送消息
     * </pre>
     */
    public void sendMsg(com.szhuima.zim.api.proto.msg.MsgProto.MsgRequest request,
        io.grpc.stub.StreamObserver<com.szhuima.zim.api.proto.msg.MsgProto.MsgResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendMsgMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 异步发送消息
     * </pre>
     */
    public void sendMsgAsync(com.szhuima.zim.api.proto.msg.MsgProto.MsgRequest request,
        io.grpc.stub.StreamObserver<com.szhuima.zim.api.proto.msg.MsgProto.MsgResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSendMsgAsyncMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service MsgService.
   */
  public static final class MsgServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<MsgServiceBlockingV2Stub> {
    private MsgServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MsgServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MsgServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     * <pre>
     * 阻塞发送消息
     * </pre>
     */
    public com.szhuima.zim.api.proto.msg.MsgProto.MsgResponse sendMsg(com.szhuima.zim.api.proto.msg.MsgProto.MsgRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendMsgMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 异步发送消息
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<?, com.szhuima.zim.api.proto.msg.MsgProto.MsgResponse>
        sendMsgAsync(com.szhuima.zim.api.proto.msg.MsgProto.MsgRequest request) {
      return io.grpc.stub.ClientCalls.blockingV2ServerStreamingCall(
          getChannel(), getSendMsgAsyncMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service MsgService.
   */
  public static final class MsgServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MsgServiceBlockingStub> {
    private MsgServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MsgServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MsgServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 阻塞发送消息
     * </pre>
     */
    public com.szhuima.zim.api.proto.msg.MsgProto.MsgResponse sendMsg(com.szhuima.zim.api.proto.msg.MsgProto.MsgRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendMsgMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 异步发送消息
     * </pre>
     */
    public java.util.Iterator<com.szhuima.zim.api.proto.msg.MsgProto.MsgResponse> sendMsgAsync(
        com.szhuima.zim.api.proto.msg.MsgProto.MsgRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSendMsgAsyncMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service MsgService.
   */
  public static final class MsgServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<MsgServiceFutureStub> {
    private MsgServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MsgServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MsgServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 阻塞发送消息
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.szhuima.zim.api.proto.msg.MsgProto.MsgResponse> sendMsg(
        com.szhuima.zim.api.proto.msg.MsgProto.MsgRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendMsgMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_MSG = 0;
  private static final int METHODID_SEND_MSG_ASYNC = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_MSG:
          serviceImpl.sendMsg((com.szhuima.zim.api.proto.msg.MsgProto.MsgRequest) request,
              (io.grpc.stub.StreamObserver<com.szhuima.zim.api.proto.msg.MsgProto.MsgResponse>) responseObserver);
          break;
        case METHODID_SEND_MSG_ASYNC:
          serviceImpl.sendMsgAsync((com.szhuima.zim.api.proto.msg.MsgProto.MsgRequest) request,
              (io.grpc.stub.StreamObserver<com.szhuima.zim.api.proto.msg.MsgProto.MsgResponse>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getSendMsgMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.szhuima.zim.api.proto.msg.MsgProto.MsgRequest,
              com.szhuima.zim.api.proto.msg.MsgProto.MsgResponse>(
                service, METHODID_SEND_MSG)))
        .addMethod(
          getSendMsgAsyncMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.szhuima.zim.api.proto.msg.MsgProto.MsgRequest,
              com.szhuima.zim.api.proto.msg.MsgProto.MsgResponse>(
                service, METHODID_SEND_MSG_ASYNC)))
        .build();
  }

  private static abstract class MsgServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MsgServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.szhuima.zim.api.proto.msg.MsgProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MsgService");
    }
  }

  private static final class MsgServiceFileDescriptorSupplier
      extends MsgServiceBaseDescriptorSupplier {
    MsgServiceFileDescriptorSupplier() {}
  }

  private static final class MsgServiceMethodDescriptorSupplier
      extends MsgServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MsgServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (MsgServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MsgServiceFileDescriptorSupplier())
              .addMethod(getSendMsgMethod())
              .addMethod(getSendMsgAsyncMethod())
              .build();
        }
      }
    }
    return result;
  }
}
