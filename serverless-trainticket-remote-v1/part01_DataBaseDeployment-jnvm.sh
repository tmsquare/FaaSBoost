echo "Part01 DataBase Deployment JNVM"

MASTER_ID=192.168.49.2
DOCKER_USERNAME=tmsquare
MODE=jnvm

cd ispn-operator/$MODE
kubectl apply -f cluster-config.yaml
kubectl apply -f my_infinispan.yaml
cd ..


cd src/initDB/jnvm

cd initContactsJNVM/
sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ init-contacts-jnvm.yml
sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ init-contacts-jnvm.yml
faas-cli up -f init-contacts-jnvm.yml
cd ..
echo "FINISHED 1/2"

cd initUserJNVM/
sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ init-user-jnvm.yml
sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ init-user-jnvm.yml
faas-cli up -f init-user-jnvm.yml
cd ..
echo "FINISHED 2/2"

cd ..

sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ part01_DataInitiation-jnvm.sh

echo "DONE"



