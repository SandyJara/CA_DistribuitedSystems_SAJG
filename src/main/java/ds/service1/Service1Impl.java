// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service1.proto

package ds.service1;

public final class Service1Impl {
  private Service1Impl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service1_ControlRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service1_ControlRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service1_ControlResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service1_ControlResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service1_LightRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service1_LightRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service1_LightResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service1_LightResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016service1.proto\022\010service1\"%\n\016ControlReq" +
      "uest\022\023\n\013temperature\030\001 \001(\005\"!\n\017ControlResp" +
      "onse\022\016\n\006action\030\001 \001(\t\"\036\n\014LightRequest\022\016\n\006" +
      "turnOn\030\001 \001(\010\"\037\n\rLightResponse\022\016\n\006status\030" +
      "\001 \001(\t2\237\001\n\010Service1\022O\n\022controlTemperature" +
      "\022\030.service1.ControlRequest\032\031.service1.Co" +
      "ntrolResponse\"\000(\0010\001\022B\n\rControlLights\022\026.s" +
      "ervice1.LightRequest\032\027.service1.LightRes" +
      "ponse\"\000B\035\n\013ds.service1B\014Service1ImplP\001b\006" +
      "proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_service1_ControlRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_service1_ControlRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service1_ControlRequest_descriptor,
        new java.lang.String[] { "Temperature", });
    internal_static_service1_ControlResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_service1_ControlResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service1_ControlResponse_descriptor,
        new java.lang.String[] { "Action", });
    internal_static_service1_LightRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_service1_LightRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service1_LightRequest_descriptor,
        new java.lang.String[] { "TurnOn", });
    internal_static_service1_LightResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_service1_LightResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service1_LightResponse_descriptor,
        new java.lang.String[] { "Status", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
