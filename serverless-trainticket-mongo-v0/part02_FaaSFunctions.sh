echo "Part02 FaaS Backend Deployment"

cd src/FaaS/


MASTER_ID=192.168.49.2
DOCKER_USERNAME=tmsquare

echo "Function deployment start"

cd createNewContacts/
sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ create-new-contacts.yml
sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ create-new-contacts.yml
faas-cli up -f create-new-contacts.yml
cd ..
echo "FINISHED 1/3"

cd getUserByUserId/
sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ get-user-by-userid.yml
sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ get-user-by-userid.yml
faas-cli up -f get-user-by-userid.yml
cd ..
echo "FINISHED 2/3"

cd getUserByUserIdNoDB/
sed -i'.original' -e s/192.168.49.2/$MASTER_ID/ get-user-by-userid-no-db.yml
sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ get-user-by-userid-no-db.yml
faas-cli up -f get-user-by-userid-no-db.yml
cd ..
echo "FINISHED 3/3"


echo "Done"