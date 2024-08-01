// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service3.proto

package ds.service3;

public final class Service3Impl {
  private Service3Impl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_SearchBookRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_SearchBookRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_SearchBookResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_SearchBookResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ReserveBookRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ReserveBookRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ReserveBookResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ReserveBookResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016service3.proto\"\"\n\021SearchBookRequest\022\r\n" +
      "\005topic\030\001 \001(\t\"n\n\022SearchBookResponse\022\r\n\005ti" +
      "tle\030\001 \001(\t\022\016\n\006author\030\002 \001(\t\022\023\n\013description" +
      "\030\003 \001(\t\022\014\n\004year\030\004 \001(\005\022\026\n\016searchFinished\030\005" +
      " \001(\010\"4\n\022ReserveBookRequest\022\016\n\006bookId\030\001 \001" +
      "(\t\022\016\n\006userId\030\002 \001(\t\"A\n\023ReserveBookRespons" +
      "e\022\032\n\022confirmationNumber\030\001 \001(\t\022\016\n\006status\030" +
      "\002 \001(\t2\211\001\n\016BooksAvailable\0229\n\nSearchBook\022\022" +
      ".SearchBookRequest\032\023.SearchBookResponse\"" +
      "\0000\001\022<\n\013ReserveBook\022\023.ReserveBookRequest\032" +
      "\024.ReserveBookResponse\"\000(\001B\035\n\013ds.service3" +
      "B\014Service3ImplP\001b\006proto3"
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
    internal_static_SearchBookRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_SearchBookRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_SearchBookRequest_descriptor,
        new java.lang.String[] { "Topic", });
    internal_static_SearchBookResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_SearchBookResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_SearchBookResponse_descriptor,
        new java.lang.String[] { "Title", "Author", "Description", "Year", "SearchFinished", });
    internal_static_ReserveBookRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_ReserveBookRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ReserveBookRequest_descriptor,
        new java.lang.String[] { "BookId", "UserId", });
    internal_static_ReserveBookResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_ReserveBookResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ReserveBookResponse_descriptor,
        new java.lang.String[] { "ConfirmationNumber", "Status", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
