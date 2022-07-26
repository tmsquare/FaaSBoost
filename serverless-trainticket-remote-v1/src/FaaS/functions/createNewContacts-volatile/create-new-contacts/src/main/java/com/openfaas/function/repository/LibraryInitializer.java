package com.openfaas.function.repository;

import org.infinispan.protostream.annotations.AutoProtoSchemaBuilder;
import org.infinispan.protostream.SerializationContextInitializer;

import entities.Contacts;
import entities.UUIDAdapter;


@AutoProtoSchemaBuilder(
        includeClasses = {
                Contacts.class,
                UUIDAdapter.class,
        },
        schemaFileName = "contacts.proto",
        schemaFilePath = "proto/",
        schemaPackageName = "contacts_proto")
public interface LibraryInitializer extends SerializationContextInitializer {
}
