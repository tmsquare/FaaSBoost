package com.openfaas.function.repository;

import org.infinispan.protostream.annotations.AutoProtoSchemaBuilder;
import org.infinispan.protostream.SerializationContextInitializer;

import com.openfaas.function.entity.User;
import com.openfaas.function.entity.UUIDAdapter;


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
