/*
 Generated by org.infinispan.protostream.annotations.impl.processor.MarshallerSourceCodeGenerator
 for class org.example.entity.UUIDAdapter
*/

package org.example.entity;

import java.util.UUID;

/**
 * WARNING: Generated code! Do not edit!
 *
 * @private
 */
@javax.annotation.Generated(
   value = "org.infinispan.protostream.annotations.impl.processor.AutoProtoSchemaBuilderAnnotationProcessor",
   comments = "Please do not edit this file!"
)
@SuppressWarnings("all")
public final class UUIDAdapter$___Marshaller_203edc8e77ccf106f83b5234cbb8398132e1012e6f01a3681fded33a7abdc390 extends org.infinispan.protostream.annotations.impl.GeneratedMarshallerBase implements org.infinispan.protostream.ProtobufTagMarshaller<java.util.UUID> {

   private final org.example.entity.UUIDAdapter __a$ = new org.example.entity.UUIDAdapter();
   
   @Override
   public Class<java.util.UUID> getJavaClass() { return java.util.UUID.class; }
   
   @Override
   public String getTypeName() { return "user_proto.UUID"; }
   
   @Override
   public java.util.UUID read(org.infinispan.protostream.ProtobufTagMarshaller.ReadContext $1) throws java.io.IOException {
      final org.infinispan.protostream.TagReader $in = $1.getReader();
      java.lang.String __v$1 = null;
      boolean done = false;
      while (!done) {
         final int tag = $in.readTag();
         switch (tag) {
            case 0: {
               done = true;
               break;
            }
            case (1 << org.infinispan.protostream.descriptors.WireType.TAG_TYPE_NUM_BITS | org.infinispan.protostream.descriptors.WireType.WIRETYPE_LENGTH_DELIMITED): {
               __v$1 = $in.readString();
               break;
            }
            default: {
               if (!$in.skipField(tag)) done = true;
            }
         }
      }
      return __a$.create(__v$1);
   }
   
   @Override
   public void write(org.infinispan.protostream.ProtobufTagMarshaller.WriteContext $1, java.util.UUID $2) throws java.io.IOException {
      final org.infinispan.protostream.TagWriter $out = $1.getWriter();
      final java.util.UUID o = (java.util.UUID) $2;
      {
         final java.lang.String __v$1 = __a$.getStringUUID(o);
         if (__v$1 != null) $out.writeString(1, __v$1);
      }
   }
}
