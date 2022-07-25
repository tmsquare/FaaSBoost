echo "Part01 Data Initiation"

echo "" | faas-cli invoke init-contacts-mongo --gateway http://192.168.49.2:31112
echo "" | faas-cli invoke init-user-mongo --gateway http://192.168.49.2:31112

faas-cli remove init-contacts-mongo --gateway http://192.168.49.2:31112
faas-cli remove init-user-mongo --gateway http://192.168.49.2:31112

echo "Done"
