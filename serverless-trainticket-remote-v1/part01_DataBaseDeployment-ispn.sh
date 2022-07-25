echo "Part01 DataBase Deployment ISPN"

MASTER_ID=192.168.49.2
DOCKER_USERNAME=tmsquare
MODE=filestore

cd ispn-operator/$MODE
kubectl apply -f cluster-config.yaml
kubectl apply -f my_infinispan.yaml
cd ..


cd src/initDB/ispn

cd initContactsISPN/
sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ init-contacts-ispn.yml
sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ init-contacts-ispn.yml
faas-cli up -f init-contacts-ispn.yml
cd ..
echo "FINISHED 1/2"

cd initUserISPN/
sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ init-user-ispn.yml
sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ init-user-ispn.yml
faas-cli up -f init-user-ispn.yml
cd ..
echo "FINISHED 2/2"

cd ..

sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ part01_DataInitiation-ispn.sh

echo "DONE"



