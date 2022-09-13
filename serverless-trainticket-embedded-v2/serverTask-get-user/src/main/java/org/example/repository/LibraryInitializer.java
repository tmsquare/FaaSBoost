package org.example.repository;


import org.infinispan.protostream.annotations.AutoProtoSchemaBuilder;
import org.infinispan.protostream.SerializationContextInitializer;

import org.example.entity.User;
import org.example.entity.UUIDAdapter;


@AutoProtoSchemaBuilder(
        includeClasses = {
                User.class,
                UUIDAdapter.class
        },
        schemaFileName = "user.proto",
        schemaFilePath = "proto/",
        schemaPackageName = "user_proto")
public interface LibraryInitializer extends SerializationContextInitializer {
}
