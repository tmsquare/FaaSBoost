echo "Part02 FaaS Backend Deployment"

cd src/FaaS/functions/


MASTER_ID=192.168.49.2
DOCKER_USERNAME=tmsquare
PATH_TO_SRC=src/main/java/

cd getUserByUserId-filestore/
sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ get-user-by-userid.yml
sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ get-user-by-userid.yml
cp -R ../../entities/* ./get-user-by-userid/$PATH_TO_SRC
faas-cli up -f get-user-by-userid.yml
rm -r ./get-user-by-userid/$PATH_TO_SRC/entities
rm -r ./get-user-by-userid/$PATH_TO_SRC/edu
cd ..
echo "FINISHED 1/4"

cd getUserByUserId-volatile/
sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ get-user-by-userid.yml
sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ get-user-by-userid.yml
cp -R ../../entities/* ./get-user-by-userid/$PATH_TO_SRC
faas-cli up -f get-user-by-userid.yml
rm -r ./get-user-by-userid/$PATH_TO_SRC/entities
rm -r ./get-user-by-userid/$PATH_TO_SRC/edu
cd ..
echo "FINISHED 2/4"

cd createNewContacts-filestore/
sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ create-new-contacts.yml
sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ create-new-contacts.yml
cp -R ../../entities/* ./create-new-contacts/$PATH_TO_SRC
faas-cli up -f create-new-contacts.yml
rm -r ./create-new-contacts/$PATH_TO_SRC/entities
rm -r ./create-new-contacts/$PATH_TO_SRC/edu
cd ..
echo "FINISHED 3/4"

cd createNewContacts-volatile/
sed -i'.original' -e s/127.0.0.1/$MASTER_ID/ create-new-contacts.yml
sed -i'.original' -e s/tmsquare/$DOCKER_USERNAME/ create-new-contacts.yml
cp -R ../../entities/* ./create-new-contacts/$PATH_TO_SRC
faas-cli up -f create-new-contacts.yml
rm -r ./create-new-contacts/$PATH_TO_SRC/entities
rm -r ./create-new-contacts/$PATH_TO_SRC/edu
cd ..
echo "FINISHED 4/4"


