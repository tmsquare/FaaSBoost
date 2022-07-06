package com.openfaas.function.repository;

import org.infinispan.protostream.annotations.AutoProtoSchemaBuilder;
import org.infinispan.protostream.SerializationContextInitializer;

import com.openfaas.function.entity.AccountInfo;
import com.openfaas.function.entity.Money;
import com.openfaas.function.entity.MoneyType;

import com.openfaas.function.entity.Payment;
import com.openfaas.function.entity.PaymentType;

import com.openfaas.function.entity.UUIDAdapter;


@AutoProtoSchemaBuilder(
        includeClasses = {
                AccountInfo.class,
                Money.class,
                MoneyType.class,
                UUIDAdapter.class
        },
        schemaFileName = "account.proto",
        schemaFilePath = "proto/",
        schemaPackageName = "account_proto")
public interface LibraryInitializer extends SerializationContextInitializer {
}
