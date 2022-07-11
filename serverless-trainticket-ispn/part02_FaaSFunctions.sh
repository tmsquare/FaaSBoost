echo "Part02 FaaS Backend Deployment"

cd src/backend/FaaS/
cd Part01/

MASTER_ID=192.168.49.2
DOCKER_USERNAME=tmsquare
PATH_TO_SRC=src/main/java/

#echo "Part1 function deployment start"
#
#cd getLeftTicketOfInterval/
#sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ get-left-ticket-of-interval.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ get-left-ticket-of-interval.yml
#cp -R ../../entities/* ./get-left-ticket-of-interval/$PATH_TO_SRC
#faas-cli up -f get-left-ticket-of-interval.yml
#rm -r ./get-left-ticket-of-interval/$PATH_TO_SRC/entities
#rm -r ./get-left-ticket-of-interval/$PATH_TO_SRC/edu
#cd ..
#echo "FINISHED 1/13"
#
#
#cd getLeftTripTickets/
#sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ get-left-trip-tickets.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ get-left-trip-tickets.yml
#cp -R ../../entities/* ./get-left-trip-tickets/$PATH_TO_SRC
#faas-cli up -f get-left-trip-tickets.yml
#rm -r ./get-left-trip-tickets/$PATH_TO_SRC/entities
#rm -r ./get-left-trip-tickets/$PATH_TO_SRC/edu
#cd ..
#echo "FINISHED 2/13"
#
#cd getPriceByRouteIdAndTrainType/
#sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ get-price-by-routeid-and-traintype.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ get-price-by-routeid-and-traintype.yml
#cp -R ../../entities/* ./get-price-by-routeid-and-traintype/$PATH_TO_SRC
#faas-cli up -f get-price-by-routeid-and-traintype.yml
#rm -r ./get-price-by-routeid-and-traintype/$PATH_TO_SRC/entities
#rm -r ./get-price-by-routeid-and-traintype/$PATH_TO_SRC/edu
#cd ..
#echo "FINISHED 3/13"
#
cd getRouteByRouteId/
sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ get-route-by-routeid.yml
sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ get-route-by-routeid.yml
cp -R ../../entities/* ./get-route-by-routeid/$PATH_TO_SRC
faas-cli up -f get-route-by-routeid.yml
rm -r ./get-route-by-routeid/$PATH_TO_SRC/entities
rm -r ./get-route-by-routeid/$PATH_TO_SRC/edu
cd ..
echo "FINISHED 4/13"
#
#cd getRouteByTripId/
#sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ get-route-by-tripid.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ get-route-by-tripid.yml
#cp -R ../../entities/* ./get-route-by-tripid/$PATH_TO_SRC
#faas-cli up -f get-route-by-tripid.yml
#rm -r ./get-route-by-tripid/$PATH_TO_SRC/entities
#rm -r ./get-route-by-tripid/$PATH_TO_SRC/edu
#cd ..
#echo "FINISHED 5/13"
#
#cd getSoldTickets/
#sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ get-sold-tickets.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ get-sold-tickets.yml
#cp -R ../../entities/* ./get-sold-tickets/$PATH_TO_SRC
#faas-cli up -f get-sold-tickets.yml
#rm -r ./get-sold-tickets/$PATH_TO_SRC/entities
#rm -r ./get-sold-tickets/$PATH_TO_SRC/edu
#cd ..
#echo "FINISHED 6/13"
#
#cd getToken/
#sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ get-token.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ get-token.yml
#cp -R ../../entities/* ./get-token/$PATH_TO_SRC
#faas-cli up -f get-token.yml
#rm -r ./get-token/$PATH_TO_SRC/entities
#rm -r ./get-token/$PATH_TO_SRC/edu
#cd ..
#echo "FINISHED 7/13"
#
#
#cd getTrainTypeByTrainTypeId/
#sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ get-traintype-by-traintypeid.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ get-traintype-by-traintypeid.yml
#cp -R ../../entities/* ./get-traintype-by-traintypeid/$PATH_TO_SRC
#faas-cli up -f get-traintype-by-traintypeid.yml
#rm -r ./get-traintype-by-traintypeid/$PATH_TO_SRC/entities
#rm -r ./get-traintype-by-traintypeid/$PATH_TO_SRC/edu
#cd ..
#echo "FINISHED 8/13"
#
#cd getTrainTypeByTripId/
#sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ get-traintype-by-tripid.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ get-traintype-by-tripid.yml
#cp -R ../../entities/* ./get-traintype-by-tripid/$PATH_TO_SRC
#faas-cli up -f get-traintype-by-tripid.yml
#rm -r ./get-traintype-by-tripid/$PATH_TO_SRC/entities
#rm -r ./get-traintype-by-tripid/$PATH_TO_SRC/edu
#cd ..
#echo "FINISHED 9/13"
#
#cd queryAlreadySoldOrders/
#sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ query-already-sold-orders.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ query-already-sold-orders.yml
#cp -R ../../entities/* ./query-already-sold-orders/$PATH_TO_SRC
#faas-cli up -f query-already-sold-orders.yml
#rm -r ./query-already-sold-orders/$PATH_TO_SRC/entities
#rm -r ./query-already-sold-orders/$PATH_TO_SRC/edu
#cd ..
#echo "FINISHED 10/13"
#
#cd queryConfigEntityByConfigName/
#sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ query-config-entity-by-config-name.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ query-config-entity-by-config-name.yml
#cp -R ../../entities/* ./query-config-entity-by-config-name/$PATH_TO_SRC
#faas-cli up -f query-config-entity-by-config-name.yml
#rm -r ./query-config-entity-by-config-name/$PATH_TO_SRC/entities
#rm -r ./query-config-entity-by-config-name/$PATH_TO_SRC/edu
#cd ..
#echo "FINISHED 11/13"
#
#cd queryForStationIdByStationName/
#sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ query-for-station-id-by-station-name.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ query-for-station-id-by-station-name.yml
#cp -R ../../entities/* ./query-for-station-id-by-station-name/$PATH_TO_SRC
#faas-cli up -f query-for-station-id-by-station-name.yml
#rm -r ./query-for-station-id-by-station-name/$PATH_TO_SRC/entities
#rm -r ./query-for-station-id-by-station-name/$PATH_TO_SRC/edu
#cd ..
#echo "FINISHED 12/13"
#
#cd queryForTravel/
#sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ query-for-travel.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ query-for-travel.yml
#cp -R ../../entities/* ./query-for-travel/$PATH_TO_SRC
#faas-cli up -f query-for-travel.yml
#rm -r ./query-for-travel/$PATH_TO_SRC/entities
#rm -r ./query-for-travel/$PATH_TO_SRC/edu
#cd ..
#echo "FINISHED 13/13"
#
#echo "Part1 function deployment finish"
#
#echo "Part2 function deployment start"
cd ..
cd Part02/

#cd checkSecurity/
#sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ check-security.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ check-security.yml
#cp -R ../../entities/* ./check-security/$PATH_TO_SRC
#faas-cli up -f get-user-by-userid.yml
#rm -r ./check-security/$PATH_TO_SRC/entities
#rm -r ./check-security/$PATH_TO_SRC/edu
#cd ..
#echo "FINISHED 1/10"
#
#cd checkSecurityAboutOrder/
#sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ check-security-about-order.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ check-security-about-order.yml
#cp -R ../../entities/* ./check-security-about-order/$PATH_TO_SRC
#faas-cli up -f check-security-about-order.yml
#rm -r ./get-user-by-userid/$PATH_TO_SRC/entities
#rm -r ./get-user-by-userid/$PATH_TO_SRC/edu
#cd ..
#echo "FINISHED 2/10"
#
#cd createNewContacts/
#sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ create-new-contacts.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ create-new-contacts.yml
#cp -R ../../entities/* ./create-new-contacts/$PATH_TO_SRC
#faas-cli up -f create-new-contacts.yml
#rm -r ./create-new-contacts/$PATH_TO_SRC/entities
#rm -r ./create-new-contacts/$PATH_TO_SRC/edu
#cd ..
#echo "FINISHED 3/10"
#
#cd createOrder/
#sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ create-order.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ create-order.yml
#cp -R ../../entities/* ./create-order/$PATH_TO_SRC
#faas-cli up -f create-order.yml
#rm -r ./create-order/$PATH_TO_SRC/entities
#rm -r ./create-order/$PATH_TO_SRC/edu
#cd ..
#echo "FINISHED 4/10"
#
#cd dipatchSeat/
#sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ dipatch-seat.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ dipatch-seat.yml
#cp -R ../../entities/* ./dipatch-seat/$PATH_TO_SRC
#faas-cli up -f dipatch-seat.yml
#rm -r ./dipatch-seat/$PATH_TO_SRC/entities
#rm -r ./dipatch-seat/$PATH_TO_SRC/edu
#cd ..
#echo "FINISHED 5/10"
#
#cd findContactsByAccountId/
#sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ find-contacts-by-accountid.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ find-contacts-by-accountid.yml
#cp -R ../../entities/* ./find-contacts-by-accountid/$PATH_TO_SRC
#faas-cli up -f find-contacts-by-accountid.yml
#rm -r ./find-contacts-by-accountid/$PATH_TO_SRC/entities
#rm -r ./find-contacts-by-accountid/$PATH_TO_SRC/edu
#cd ..
#echo "FINISHED 6/10"
#
#cd getContactsByContactsId/
#sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ get-contacts-by-contactsid.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ get-contacts-by-contactsid.yml
#cp -R ../../entities/* ./get-contacts-by-contactsid/$PATH_TO_SRC
#faas-cli up -f get-contacts-by-contactsid.yml
#rm -r ./get-contacts-by-contactsid/$PATH_TO_SRC/entities
#rm -r ./get-contacts-by-contactsid/$PATH_TO_SRC/edu
#cd ..
#echo "FINISHED 7/10"
#
#cd getTripAllDetailInfo/
#sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ get-trip-all-detai-info.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ get-trip-all-detai-info.yml
#cp -R ../../entities/* ./get-trip-all-detai-info/$PATH_TO_SRC
#faas-cli up -f get-trip-all-detai-info.yml
#rm -r ./get-trip-all-detai-info/$PATH_TO_SRC/entities
#rm -r ./get-trip-all-detai-info/$PATH_TO_SRC/edu
#cd ..
#echo "FINISHED 8/10"
#
cd getUserByUserId/
sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ get-user-by-userid.yml
sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ get-user-by-userid.yml
cp -R ../../entities/* ./get-user-by-userid/$PATH_TO_SRC
faas-cli up -f get-user-by-userid.yml
rm -r ./get-user-by-userid/$PATH_TO_SRC/entities
rm -r ./get-user-by-userid/$PATH_TO_SRC/edu
cd ..
#echo "FINISHED 9/10"

#cd preserveTicket/
#sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ preserve-ticket.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ preserve-ticket.yml
#cp -R ../../entities/* ./preserve-ticket/$PATH_TO_SRC
#faas-cli up -f preserve-ticket.yml
#rm -r ./preserve-ticket/$PATH_TO_SRC/entities
#rm -r ./preserve-ticket/$PATH_TO_SRC/edu
#cd ..
#echo "FINISHED 10/10"
#
#echo "Part2 function deployment finish"
#
#echo "Part3 function deployment start"
#cd ..
#cd Part03/
#
#cd calculateRefund/
#sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ calculate-refund.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ calculate-refund.yml
#cp -R ../../entities/* ./calculate-refund/$PATH_TO_SRC
#faas-cli up -f calculate-refund.yml
#rm -r ./calculate-refund/$PATH_TO_SRC/entities
#rm -r ./calculate-refund/$PATH_TO_SRC/edu
#cd ..
#echo "FINISHED 1/10"
#
#cd cancelTicket/
#sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ cancel-ticket.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ cancel-ticket.yml
#cp -R ../../entities/* ./cancel-ticket/$PATH_TO_SRC
#faas-cli up -f cancel-ticket.yml
#rm -r ./cancel-ticket/$PATH_TO_SRC/entities
#rm -r ./cancel-ticket/$PATH_TO_SRC/edu
#cd ..
#echo "FINISHED 2/10"
#
#cd createThirdPartyPaymentAndPay/
#sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ create-third-party-payment-and-pay.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ create-third-party-payment-and-pay.yml
#cp -R ../../entities/* ./create-third-party-payment-and-pay/$PATH_TO_SRC
#faas-cli up -f create-third-party-payment-and-pay.yml
#rm -r ./create-third-party-payment-and-pay/$PATH_TO_SRC/entities
#rm -r ./create-third-party-payment-and-pay/$PATH_TO_SRC/edu
#cd ..
#echo "FINISHED 3/10"
#
#cd drawBack/
#sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ drawback.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ drawback.yml
#cp -R ../../entities/* ./drawback/$PATH_TO_SRC
#faas-cli up -f drawback.yml
#rm -r ./drawback/$PATH_TO_SRC/entities
#rm -r ./drawback/$PATH_TO_SRC/edu
#cd ..
#echo "FINISHED 4/10"
#
#cd getOrderById/
#sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ get-order-by-id.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ get-order-by-id.yml
#cp -R ../../entities/* ./get-order-by-id/$PATH_TO_SRC
#faas-cli up -f get-order-by-id.yml
#rm -r ./get-order-by-id/$PATH_TO_SRC/entities
#rm -r ./get-order-by-id/$PATH_TO_SRC/edu
#cd ..
#echo "FINISHED 5/10"
#
#cd getStationIdListByNameList/
#sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ get-stationid-list-by-name-list.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ get-stationid-list-by-name-list.yml
#cp -R ../../entities/* ./get-stationid-list-by-name-list/$PATH_TO_SRC
#faas-cli up -f get-stationid-list-by-name-list.yml
#rm -r ./get-stationid-list-by-name-list/$PATH_TO_SRC/entities
#rm -r ./get-stationid-list-by-name-list/$PATH_TO_SRC/edu
#cd ..
#echo "FINISHED 6/10"
#
#cd modifyOrder/
#sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ modify-order.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ modify-order.yml
#cp -R ../../entities/* ./modify-order/$PATH_TO_SRC
#faas-cli up -f modify-order.yml
#rm -r ./modify-order/$PATH_TO_SRC/entities
#rm -r ./modify-order/$PATH_TO_SRC/edu
#cd ..
#echo "FINISHED 7/10"
#
#cd payForTheOrder/
#sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ pay-for-the-order.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ pay-for-the-order.yml
#cp -R ../../entities/* ./pay-for-the-order/$PATH_TO_SRC
#faas-cli up -f pay-for-the-order.yml
#rm -r ./pay-for-the-order/$PATH_TO_SRC/entities
#rm -r ./pay-for-the-order/$PATH_TO_SRC/edu
#cd ..
#echo "FINISHED 8/10"
#
#cd queryOrdersForRefresh/
#sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ query-orders-for-refresh.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ query-orders-for-refresh.yml
#cp -R ../../entities/* ./query-orders-for-refresh/$PATH_TO_SRC
#faas-cli up -f query-orders-for-refresh.yml
#rm -r ./query-orders-for-refresh/$PATH_TO_SRC/entities
#rm -r ./query-orders-for-refresh/$PATH_TO_SRC/edu
#cd ..
#echo "FINISHED 9/10"
#
#cd saveOrderInfo/
#sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ save-order-info.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ save-order-info.yml
#cp -R ../../entities/* ./save-order-info/$PATH_TO_SRC
#faas-cli up -f save-order-info.yml
#rm -r ./save-order-info/$PATH_TO_SRC/entities
#rm -r ./save-order-info/$PATH_TO_SRC/edu
#cd ..
#echo "FINISHED 10/10"
#
#echo "Part3 function deployment finish"
#
#cd ..
#cd ..
#cd ..
#cd ..
#echo "Done"
#