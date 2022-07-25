echo "Part01 Data Initiation JNVM"

echo "" | faas-cli invoke init-contacts-jnvm --gateway http://192.168.49.2:31112
echo "" | faas-cli invoke init-user-jnvm --gateway http://192.168.49.2:31112

faas-cli remove init-contacts-jnvm --gateway http://192.168.49.2:31112
faas-cli remove init-user-jnvm --gateway http://192.168.49.2:31112


echo "Done"
