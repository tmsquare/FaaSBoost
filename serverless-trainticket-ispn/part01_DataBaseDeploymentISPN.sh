#echo "Part01 DataBase Deployment"
#
MASTER_ID=192.168.49.2
DOCKER_USERNAME=tmsquare
#
#cd ispn-operator/
#kubectl apply -f cluster-config.yaml
#kubectl apply -f my_infinispan.yaml
#cd ..
#
#
cd src/initDB-ispn/initDatabaseFunctions/
#
#
#cd initAuthISPN/
#sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ init-auth-ispn.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ init-auth-ispn.yml
#faas-cli up -f init-auth-ispn.yml
#cd ..
#echo "FINISHED 1/13"
#
#cd initConfigISPN/
#sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ init-config-ispn.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ init-config-ispn.yml
#faas-cli up -f init-config-ispn.yml
#cd ..
#echo "FINISHED 2/13"
#
#cd initContactsISPN/
#sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ init-contacts-ispn.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ init-contacts-ispn.yml
#faas-cli up -f init-contacts-ispn.yml
#cd ..
#echo "FINISHED 3/13"

cd initInsidePaymentISPN/
sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ init-inside-payment-ispn.yml
sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ init-inside-payment-ispn.yml
faas-cli up -f init-inside-payment-ispn.yml
cd ..
echo "FINISHED 4/13"

#cd initOrderISPN/
#sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ init-order-ispn.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ init-order-ispn.yml
#faas-cli up -f init-order-ispn.yml
#cd ..
#echo "FINISHED 5/13"
#
#cd initPaymentISPN/
#sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ init-payment-ispn.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ init-payment-ispn.yml
#faas-cli up -f init-payment-ispn.yml
#cd ..
#echo "FINISHED 6/13"
#
#cd initPriceISPN/
#sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ init-price-ispn.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ init-price-ispn.yml
#faas-cli up -f init-price-ispn.yml
#cd ..
#echo "FINISHED 7/13"
#
#cd initRouteISPN/
#sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ init-route-ispn.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ init-route-ispn.yml
#faas-cli up -f init-route-ispn.yml
#cd ..
#echo "FINISHED 8/13"
#
#cd initSecurityISPN/
#sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ init-security-ispn.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ init-security-ispn.yml
#faas-cli up -f init-security-ispn.yml
#cd ..
#echo "FINISHED 9/13"
#
#cd initStationISPN/
#sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ init-station-ispn.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ init-station-ispn.yml
#faas-cli up -f init-station-ispn.yml
#cd ..
#echo "FINISHED 10/13"
#
#cd initTrainISPN/
#sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ init-train-ispn.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ init-train-ispn.yml
#faas-cli up -f init-train-ispn.yml
#cd ..
#echo "FINISHED 11/13"
#
#cd initTravelISPN/
#sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ init-travel-ispn.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ init-travel-ispn.yml
#faas-cli up -f init-travel-ispn.yml
#cd ..
#echo "FINISHED 12/13"
#
#cd initUserISPN/
#sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ init-user-ispn.yml
#sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ init-user-ispn.yml
#faas-cli up -f init-user-ispn.yml
#cd ..
#echo "FINISHED 13/13"
#
#cd ..
#cd ..
#cd ..
#
#sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ part01_DataInitiationISPN.sh
#
#echo "DONE"



