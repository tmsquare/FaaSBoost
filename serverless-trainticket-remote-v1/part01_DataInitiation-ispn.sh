echo "Part01 Data Initiation ISPN"

echo "" | faas-cli invoke init-contacts-ispn --gateway http://192.168.49.2:31112
echo "" | faas-cli invoke init-user-ispn --gateway http://192.168.49.2:31112

faas-cli remove init-contacts-ispn --gateway http://192.168.49.2:31112
faas-cli remove init-user-ispn --gateway http://192.168.49.2:31112

echo "Done"
