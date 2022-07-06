package com.openfaas.function.repository;

import org.infinispan.protostream.annotations.AutoProtoSchemaBuilder;
import org.infinispan.protostream.SerializationContextInitializer;

import com.openfaas.function.entity.Trip;
import com.openfaas.function.entity.TripId;
import com.openfaas.function.entity.Type;
import com.openfaas.function.entity.UUIDAdapter;


@AutoProtoSchemaBuilder(
        includeClasses = {
                Trip.class,
                TripId.class,
                Type.class,
                UUIDAdapter.class
        },
        schemaFileName = "trip.proto",
        schemaFilePath = "proto/",
        schemaPackageName = "trip_proto")
public interface LibraryInitializer extends SerializationContextInitializer {
}
