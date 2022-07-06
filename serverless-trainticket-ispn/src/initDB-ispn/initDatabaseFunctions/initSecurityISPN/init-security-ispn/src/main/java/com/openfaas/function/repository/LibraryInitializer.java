package com.openfaas.function.repository;

import org.infinispan.protostream.annotations.AutoProtoSchemaBuilder;
import org.infinispan.protostream.SerializationContextInitializer;

import com.openfaas.function.entity.SecurityConfig;
import com.openfaas.function.entity.UUIDAdapter;


@AutoProtoSchemaBuilder(
        includeClasses = {
                SecurityConfig.class,
                UUIDAdapter.class
        },
        schemaFileName = "security.proto",
        schemaFilePath = "proto/",
        schemaPackageName = "security_proto")
public interface LibraryInitializer extends SerializationContextInitializer {
}
