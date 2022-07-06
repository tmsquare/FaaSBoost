package com.openfaas.function.repository;

import org.infinispan.protostream.annotations.AutoProtoSchemaBuilder;
//import org.infinispan.protostream.types.java.util.UUIDAdapter;
import org.infinispan.protostream.SerializationContextInitializer;

import com.openfaas.function.entity.Config;


@AutoProtoSchemaBuilder(
        includeClasses = {
                Config.class,
        },
        schemaFileName = "config.proto",
        schemaFilePath = "proto/",
        schemaPackageName = "config_proto")
public interface LibraryInitializer extends SerializationContextInitializer {
}
