echo "Part01 Data Initiation"

echo "" | faas-cli invoke init-auth-ispn --gateway http://192.168.49.2:31112
echo "" | faas-cli invoke init-config-ispn --gateway http://192.168.49.2:31112
echo "" | faas-cli invoke init-contacts-ispn --gateway http://192.168.49.2:31112
echo "" | faas-cli invoke init-inside-payment-ispn --gateway http://192.168.49.2:31112
echo "" | faas-cli invoke init-order-ispn --gateway http://192.168.49.2:31112
echo "" | faas-cli invoke init-payment-ispn --gateway http://192.168.49.2:31112
echo "" | faas-cli invoke init-price-ispn --gateway http://192.168.49.2:31112
echo "" | faas-cli invoke init-route-ispn --gateway http://192.168.49.2:31112
echo "" | faas-cli invoke init-security-ispn --gateway http://192.168.49.2:31112
echo "" | faas-cli invoke init-station-ispn --gateway http://192.168.49.2:31112
echo "" | faas-cli invoke init-train-ispn --gateway http://192.168.49.2:31112
echo "" | faas-cli invoke init-travel-ispn --gateway http://192.168.49.2:31112
echo "" | faas-cli invoke init-user-ispn --gateway http://192.168.49.2:31112

faas-cli remove init-auth-ispn --gateway http://192.168.49.2:31112
faas-cli remove init-config-ispn --gateway http://192.168.49.2:31112
faas-cli remove init-contacts-ispn --gateway http://192.168.49.2:31112
faas-cli remove init-inside-payment-ispn --gateway http://192.168.49.2:31112
faas-cli remove init-order-ispn --gateway http://192.168.49.2:31112
faas-cli remove init-payment-ispn --gateway http://192.168.49.2:31112
faas-cli remove init-price-ispn --gateway http://192.168.49.2:31112
faas-cli remove init-route-ispn --gateway http://192.168.49.2:31112
faas-cli remove init-security-ispn --gateway http://192.168.49.2:31112
faas-cli remove init-station-ispn --gateway http://192.168.49.2:31112
faas-cli remove init-train-ispn --gateway http://192.168.49.2:31112
faas-cli remove init-travel-ispn --gateway http://192.168.49.2:31112
faas-cli remove init-user-ispn --gateway http://192.168.49.2:31112


echo "Done"
