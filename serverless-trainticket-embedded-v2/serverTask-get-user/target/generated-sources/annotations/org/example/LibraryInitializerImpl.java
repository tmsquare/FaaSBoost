/*
 Generated by org.infinispan.protostream.annotations.impl.processor.AutoProtoSchemaBuilderAnnotationProcessor
 for class org.example.repository.LibraryInitializer
 annotated with @org.infinispan.protostream.annotations.AutoProtoSchemaBuilder(dependsOn=, marshallersOnly=false, service=true, autoImportClasses=false, excludeClasses=, includeClasses=org.example.entity.User,org.example.entity.UUIDAdapter, basePackages={}, value={}, schemaPackageName="user_proto", schemaFilePath="proto/", schemaFileName="user.proto", className="")
 */

package org.example;

import org.example.repository.LibraryInitializer;

/**
 * WARNING: Generated code! Do not edit!
 */
@javax.annotation.Generated(
   value = "org.infinispan.protostream.annotations.impl.processor.AutoProtoSchemaBuilderAnnotationProcessor",
   comments = "Please do not edit this file!"
)
@org.infinispan.protostream.annotations.impl.processor.OriginatingClasses({
   org.example.entity.UUIDAdapter.class,
   org.example.entity.User.class
})
/*@org.infinispan.protostream.annotations.AutoProtoSchemaBuilder(
   className = "LibraryInitializerImpl",
   schemaFileName = "user.proto",
   schemaFilePath = "proto/",
   schemaPackageName = "user_proto",
   service = true,
   marshallersOnly = false,
   autoImportClasses = false,
   includeClasses = {
      org.example.entity.UUIDAdapter.class,
      org.example.entity.User.class
   }
)*/
@SuppressWarnings("all")
public class LibraryInitializerImpl implements LibraryInitializer, org.infinispan.protostream.GeneratedSchema {

   @Override
   public String getProtoFileName() { return "user.proto"; }
   
   @Override
   public String getProtoFile() { return org.infinispan.protostream.impl.ResourceUtils.getResourceAsString(getClass(), "/proto/user.proto"); }
   
   @Override
   public java.io.Reader getProtoFileReader() { return org.infinispan.protostream.impl.ResourceUtils.getResourceAsReader(getClass(), "/proto/user.proto"); }
   
   @Override
   public void registerSchema(org.infinispan.protostream.SerializationContext serCtx) {
      serCtx.registerProtoFiles(org.infinispan.protostream.FileDescriptorSource.fromString(getProtoFileName(), getProtoFile()));
   }
   
   @Override
   public void registerMarshallers(org.infinispan.protostream.SerializationContext serCtx) {
      serCtx.registerMarshaller(new org.example.entity.User$___Marshaller_dbc093248f5ff5d62a7bf0297f32ebeb402aa3f989ed7b7c86a168c3d3bc458b());
      serCtx.registerMarshaller(new org.example.entity.UUIDAdapter$___Marshaller_203edc8e77ccf106f83b5234cbb8398132e1012e6f01a3681fded33a7abdc390());
   }
}
