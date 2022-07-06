package com.openfaas.function.repository;

import org.infinispan.protostream.annotations.AutoProtoSchemaBuilder;
import org.infinispan.protostream.SerializationContextInitializer;

import com.openfaas.function.entity.Station;
import com.openfaas.function.entity.UUIDAdapter;


@AutoProtoSchemaBuilder(
        includeClasses = {
                Station.class,
                UUIDAdapter.class
        },
        schemaFileName = "station.proto",
        schemaFilePath = "proto/",
        schemaPackageName = "station_proto")
public interface LibraryInitializer extends SerializationContextInitializer {
}
