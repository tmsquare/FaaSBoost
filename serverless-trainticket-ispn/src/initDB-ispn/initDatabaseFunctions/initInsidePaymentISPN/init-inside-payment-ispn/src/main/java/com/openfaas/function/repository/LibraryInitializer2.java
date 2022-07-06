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
                Payment.class,
                PaymentType.class,
                UUIDAdapter.class
        },
        schemaFileName = "payment.proto",
        schemaFilePath = "proto/",
        schemaPackageName = "payment_proto")
public interface LibraryInitializer2 extends SerializationContextInitializer {
}
