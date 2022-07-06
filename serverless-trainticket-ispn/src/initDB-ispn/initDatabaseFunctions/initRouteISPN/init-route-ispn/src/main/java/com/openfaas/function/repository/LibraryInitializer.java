package com.openfaas.function.repository;

import org.infinispan.protostream.annotations.AutoProtoSchemaBuilder;
import org.infinispan.protostream.SerializationContextInitializer;

import com.openfaas.function.entity.RouteInfo;
import com.openfaas.function.entity.UUIDAdapter;


@AutoProtoSchemaBuilder(
        includeClasses = {
                RouteInfo.class,
                UUIDAdapter.class
        },
        schemaFileName = "route.proto",
        schemaFilePath = "proto/",
        schemaPackageName = "route_proto")
public interface LibraryInitializer extends SerializationContextInitializer {
}
