package com.openfaas.function.repository;

import org.infinispan.protostream.annotations.AutoProtoSchemaBuilder;
import org.infinispan.protostream.SerializationContextInitializer;

import com.openfaas.function.entity.TrainType;
import com.openfaas.function.entity.UUIDAdapter;


@AutoProtoSchemaBuilder(
        includeClasses = {
                TrainType.class,
                UUIDAdapter.class
        },
        schemaFileName = "train.proto",
        schemaFilePath = "proto/",
        schemaPackageName = "train_proto")
public interface LibraryInitializer extends SerializationContextInitializer {
}
