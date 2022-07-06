package com.openfaas.function.repository;

import org.infinispan.protostream.annotations.AutoProtoSchemaBuilder;
import org.infinispan.protostream.SerializationContextInitializer;

import com.openfaas.function.entity.Order;
import com.openfaas.function.entity.UUIDAdapter;


@AutoProtoSchemaBuilder(
        includeClasses = {
                Order.class,
                UUIDAdapter.class
        },
        schemaFileName = "order.proto",
        schemaFilePath = "proto/",
        schemaPackageName = "order_proto")
public interface LibraryInitializer extends SerializationContextInitializer {
}