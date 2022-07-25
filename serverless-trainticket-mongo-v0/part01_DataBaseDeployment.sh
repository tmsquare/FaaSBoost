echo "Part01 DataBase Deployment"

MASTER_ID=192.168.49.2
DOCKER_USERNAME=tmsquare

cd deployment/
kubectl apply -f storage-class.yml -n openfaas

kubectl apply -f ts-serverless-persistent-deployment.yml

kubectl apply -f ts-serverless-database-deployment.yml
cd ..

cd src/initDB/

cd initContactsMongo/
sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ init-contacts-mongo.yml
sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ init-contacts-mongo.yml
faas-cli up -f init-contacts-mongo.yml
cd ..
echo "FINISHED 1/2"

cd initUserMongo/
sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ init-user-mongo.yml
sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ init-user-mongo.yml
faas-cli up -f init-user-mongo.yml
cd ..
echo "FINISHED 2/2"

cd ..
cd ..

sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ part01_DataInitiation.sh

echo "DONE"



