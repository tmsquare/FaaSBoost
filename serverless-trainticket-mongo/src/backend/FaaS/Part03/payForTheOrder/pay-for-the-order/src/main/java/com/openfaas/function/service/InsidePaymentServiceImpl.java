package com.openfaas.function.service;

import com.openfaas.function.repository.AddMoneyRepositoryImpl;
import com.openfaas.function.repository.PaymentRepositoryImpl;
import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;
import com.openfaas.function.entity.*;

import com.openfaas.function.repository.AddMoneyRepository;
import com.openfaas.function.repository.PaymentRepository;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author fdse
 */
public class InsidePaymentServiceImpl implements InsidePaymentService {

    public AddMoneyRepository addMoneyRepository=new AddMoneyRepositoryImpl();

    public PaymentRepository paymentRepository=new PaymentRepositoryImpl();

    //private OkHttpClient client = new OkHttpClient();
    private HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    String function23_URI = "gateway.openfaas:8080/function/get-order-by-id.openfaas-fn";
    String function24_URI = "gateway.openfaas:8080/function/modify-order.openfaas-fn";
    String function25_URI = "gateway.openfaas:8080/function/create-third-party-payment-and-pay.openfaas-fn";

    @Override
    public mResponse pay(PaymentInfo info) {

        String userId = info.getUserId();

        String ret = "";
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("http://" + function23_URI + "/orderId/" + info.getOrderId()))
                    .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            ret = response.body();

        } catch (Exception e) {
            e.printStackTrace();
        }
        mResponse<Order> result = JsonUtils.json2Object(ret, mResponse.class);


        if (result.getStatus() == 1) {
            Order order = JsonUtils.conveterObject(result.getData(),Order.class);
            if (order.getStatus() != OrderStatus.NOTPAID.getCode()) {
                //InsidePaymentServiceImpl.LOGGER.info("[Inside Payment Service][Pay] Error. Order status Not allowed to Pay.");
                return new mResponse<>(0, "Error. Order status Not allowed to Pay.", null);
            }

            Payment payment = new Payment();
            payment.setOrderId(info.getOrderId());
            payment.setPrice(order.getPrice());
            payment.setUserId(userId);

            //判断一下账户余额够不够，不够要去站外支付
            List<Payment> payments = paymentRepository.findByUserId(userId);
            List<Money> addMonies = addMoneyRepository.findByUserId(userId);
            Iterator<Payment> paymentsIterator = payments.iterator();
            Iterator<Money> addMoniesIterator = addMonies.iterator();

            BigDecimal totalExpand = new BigDecimal("0");
            while (paymentsIterator.hasNext()) {
                Payment p = paymentsIterator.next();
                totalExpand = totalExpand.add(new BigDecimal(p.getPrice()));
            }
            totalExpand = totalExpand.add(new BigDecimal(order.getPrice()));

            BigDecimal money = new BigDecimal("0");
            while (addMoniesIterator.hasNext()) {
                Money addMoney = addMoniesIterator.next();
                money = money.add(new BigDecimal(addMoney.getMoney()));
            }

            if (totalExpand.compareTo(money) > 0) {
                //站外支付
                Payment outsidePaymentInfo = new Payment();
                outsidePaymentInfo.setOrderId(info.getOrderId());
                outsidePaymentInfo.setUserId(userId);
                outsidePaymentInfo.setPrice(order.getPrice());

                /****这里调用第三方支付***/

                String json = JsonUtils.object2Json(outsidePaymentInfo);
                try {
                    HttpRequest request = HttpRequest.newBuilder()
                            .POST(HttpRequest.BodyPublishers.ofString(json))
                            .uri(URI.create("http://" + function25_URI))
                            .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                            .header("Content-Type", "application/json")
                            .build();

                    HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                    ret = response.body();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                mResponse outsidePaySuccess = JsonUtils.json2Object(ret, mResponse.class);


                //InsidePaymentServiceImpl.LOGGER.info("Out pay result: {}", outsidePaySuccess.toString());
                if (outsidePaySuccess.getStatus() == 1) {
                    payment.setType(PaymentType.O);
                    paymentRepository.save(payment);
                    setOrderStatus( info.getOrderId());
                    return new mResponse<>(1, "Payment Success " + outsidePaySuccess.getMsg(), null);
                } else {
                    return new mResponse<>(0, "Payment Failed:  " + outsidePaySuccess.getMsg(), null);
                }
            } else {
                setOrderStatus(info.getOrderId());
                payment.setType(PaymentType.P);
                paymentRepository.save(payment);
            }
            return new mResponse<>(1, "Payment Success", null);

        } else {
            return new mResponse<>(0, "Payment Failed, Order Not Exists", null);
        }
    }


    private mResponse setOrderStatus(String orderId) {
        //order paid and not collected
        int orderStatus = 1;
        mResponse result;
        String ret = "";
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("http://" + function24_URI + "/orderId/" + orderId+ "/orderStatus/" + orderStatus))
                    .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            ret = response.body();

        } catch (Exception e) {
            e.printStackTrace();
        }

        result = JsonUtils.json2Object(ret, mResponse.class);
        return result;
    }

}
