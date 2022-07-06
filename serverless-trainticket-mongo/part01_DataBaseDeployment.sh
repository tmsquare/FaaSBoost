echo "Part01 DataBase Deployment"

MASTER_ID=192.168.49.2
DOCKER_USERNAME=tmsquare

cd deployment/Part01-database/
kubectl apply -f storage-class.yml -n openfaas

kubectl apply -f ts-serverless-persistent-deployment.yml

kubectl apply -f ts-serverless-database-deployment.yml
cd ..
cd ..
cd src/initDB/initDatabaseFunctions/

cd initAuthMongo/
sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ init-auth-mongo.yml
sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ init-auth-mongo.yml
faas-cli up -f init-auth-mongo.yml
cd ..
echo "FINISHED 1/13"

cd initConfigMongo/
sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ init-config-mongo.yml
sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ init-config-mongo.yml
faas-cli up -f init-config-mongo.yml
cd ..
echo "FINISHED 2/13"

cd initContactsMongo/
sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ init-contacts-mongo.yml
sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ init-contacts-mongo.yml
faas-cli up -f init-contacts-mongo.yml
cd ..
echo "FINISHED 3/13"

cd initInsidePaymentMongo/
sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ init-inside-payment-mongo.yml
sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ init-inside-payment-mongo.yml
faas-cli up -f init-inside-payment-mongo.yml
cd ..
echo "FINISHED 4/13"

cd initOrderMongo/
sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ init-order-mongo.yml
sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ init-order-mongo.yml
faas-cli up -f init-order-mongo.yml
cd ..
echo "FINISHED 5/13"

cd initPaymentMongo/
sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ init-payment-mongo.yml
sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ init-payment-mongo.yml
faas-cli up -f init-payment-mongo.yml
cd ..
echo "FINISHED 6/13"

cd initPriceMongo/
sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ init-price-mongo.yml
sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ init-price-mongo.yml
faas-cli up -f init-price-mongo.yml
cd ..
echo "FINISHED 7/13"

cd initRouteMongo/
sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ init-route-mongo.yml
sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ init-route-mongo.yml
faas-cli up -f init-route-mongo.yml
cd ..
echo "FINISHED 8/13"

cd initSecurityMongo/
sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ init-security-mongo.yml
sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ init-security-mongo.yml
faas-cli up -f init-security-mongo.yml
cd ..
echo "FINISHED 9/13"

cd initStationMongo/
sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ init-station-mongo.yml
sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ init-station-mongo.yml
faas-cli up -f init-station-mongo.yml
cd ..
echo "FINISHED 10/13"

cd initTrainMongo/
sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ init-train-mongo.yml
sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ init-train-mongo.yml
faas-cli up -f init-train-mongo.yml
cd ..
echo "FINISHED 11/13"

cd initTravelMongo/
sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ init-travel-mongo.yml
sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ init-travel-mongo.yml
faas-cli up -f init-travel-mongo.yml
cd ..
echo "FINISHED 12/13"

cd initUserMongo/
sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ init-user-mongo.yml
sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ init-user-mongo.yml
faas-cli up -f init-user-mongo.yml
cd ..
echo "FINISHED 13/13"

cd ..
cd ..
cd ..

sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ part01_DataInitiation.sh

echo "DONE"



