MASTER_ID=

http://$MASTER_ID:8080/function/get-left-ticket-of-interval/ -d { arg1:"", arg2:"" }  # getBody Seat.class

http://$MASTER_ID:8080/function/get-left-trip-tickets/ -d { arg1:"", arg2:"" } # getBody TripInfo.class

http://$MASTER_ID:8080/function/get-price-by-routeid-and-traintype/routId/${routeId}/trainType/${trainType} # getPath

http://$MASTER_ID:8080/function/get-route-by-routeid/${routeId} # getPath

http://$MASTER_ID:8080/function/get-route-by-tripid/${tripId} # getPath

http://$MASTER_ID:8080/function/get-sold-tickets/ -d { arg1:"", arg2:"" }  # getBody Seat.class

http://$MASTER_ID:8080/function/get-token/ -d { arg1:"", arg2:"" }  # getBody BasicAuthDto.class

http://$MASTER_ID:8080/function/get-traintype-by-traintypeid/trainTypeId/${trainTypeId}

http://$MASTER_ID:8080/function/get-traintype-by-tripid/tripId/${tripId}

http://$MASTER_ID:8080/function/query-already-sold-orders/routeId/${routeId}/trainType/${trainType}

http://$MASTER_ID:8080/function/query-config-entity-by-config-name/configName/${configName}

http://$MASTER_ID:8080/function/query-for-station-id-by-station-name/stationName/${stationName}

http://$MASTER_ID:8080/function/query-for-travel/ -d { arg1:"", arg2:"" } # getBody Travel.class

http://$MASTER_ID:8080/function/check-security/accountId/${accountId}

http://$MASTER_ID:8080/function/check-security-about-order/accountId/${accountId}/checkDate/${checkDate}

http://$MASTER_ID:8080/function/create-new-contacts/ -d { arg1:"", arg2:"" } # getBody Contacts.class
# {\"id\": \"4d2a46c7-71cb-4cf1-b5bb-b68406d9da67\", \"accountId\": \"9e0b2927-67fa-4bd1-8198-cdad5c762289\", \"name\": \"Contacts_One\", \"documentType\": \"1\", \"documentNumber\": \"DocumentNumber_One\", \"phoneNumber\": \"ContactsPhoneNum_One\"}"

http://$MASTER_ID:8080/function/create-order/ -d { arg1:"", arg2:"" } # getBody Order.class

http://$MASTER_ID:8080/function/dipatch-seat/ -d { arg1:"", arg2:"" } # getBody Seat.class

http://$MASTER_ID:8080/function/find-contacts-by-accountid/accountId/${accountId}

http://$MASTER_ID:8080/function/get-contacts-by-contactsid/contactsId/${contactsId}

http://$MASTER_ID:8080/function/get-trip-all-detai-info/ -d { arg1:"", arg2:"" } # getBody TripAllDetailInfo.class

http://$MASTER_ID:8080/function/get-user-by-userid/accountId/${accountId}

http://$MASTER_ID:8080/function/preserve-ticket/ -d { arg1:"", arg2:"" } # getBody OrderTicketsInfo.class

http://$MASTER_ID:8080/function/calculate-refund/orderId/${orderId}

http://$MASTER_ID:8080/function/cancel-ticket/orderId/${orderId}/loginId/${loginId}

http://$MASTER_ID:8080/function/create-third-party-payment-and-pay/ -d { arg1:"", arg2:"" } # getBody PaymentInfo.class

http://$MASTER_ID:8080/function/drawback/userId/${userId}/money/${money}

http://$MASTER_ID:8080/function/get-order-by-id/orderId/${orderId}

http://$MASTER_ID:8080/function/get-stationid-list-by-name-list/ -d { arg1:"", arg2:"" } # getBody List.class

http://$MASTER_ID:8080/function/modify-order/orderId/${orderId}/orderStatus/${orderStatus}

http://$MASTER_ID:8080/function/pay-for-the-order/ -d { arg1:"", arg2:"" } # getBody PaymentInfo.class

http://$MASTER_ID:8080/function/query-orders-for-refresh/ -d { arg1:"", arg2:"" } # getBody OrderInfo.class

http://$MASTER_ID:8080/function/save-order-info/ -d { arg1:"", arg2:"" } # getBody Order.class



