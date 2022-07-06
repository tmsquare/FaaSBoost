package com.openfaas.function.repository;

import org.infinispan.protostream.annotations.AutoProtoSchemaBuilder;
import org.infinispan.protostream.SerializationContextInitializer;

import com.openfaas.function.entity.PriceConfig;
import com.openfaas.function.entity.UUIDAdapter;


@AutoProtoSchemaBuilder(
        includeClasses = {
                PriceConfig.class,
                UUIDAdapter.class
        },
        schemaFileName = "price.proto",
        schemaFilePath = "proto/",
        schemaPackageName = "price_proto")
public interface LibraryInitializer extends SerializationContextInitializer {
}
