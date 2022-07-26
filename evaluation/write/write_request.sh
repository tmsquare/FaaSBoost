#!/bin/sh

if [ $# -ne 2 ]; then
    echo "usage: OPENFAAS_URL ncalls";
    exit 1;
fi

ncalls=$2
a=601000000000
a=$(expr $a + $ncalls)
command="curl  -L http://$1:31112/function/create-new-contacts-no-db/ -d \"{\\\"id\\\": \\\"4d2a46c7-71cb-4cf1-b5bb-$a\\\", \\\"accountId\\\": \\\"9e0b2927-67fa-4bd1-8198-$a\\\", \\\"name\\\": \\\"Contacts_One\\\", \\\"documentType\\\": \\\"1\\\", \\\"documentNumber\\\": \\\"DocumentNumber_One\\\", \\\"phoneNumber\\\": \\\"ContactsPhoneNum_One\\\"}\" "

for i in `seq 2 ${ncalls}`
do
  a=$(expr $a + $i)
  command=${command}" -: http://$1:31112/function/create-new-contacts-volatile-no-db/ -d \"{\\\"id\\\": \\\"4d2a46c7-71cb-4cf1-b5bb-"$a"\\\", \\\"accountId\\\": \\\"9e0b2927-67fa-4bd1-8198-"$a"\\\", \\\"name\\\": \\\"Contacts_One\\\", \\\"documentType\\\": \\\"1\\\", \\\"documentNumber\\\": \\\"DocumentNumber_One\\\", \\\"phoneNumber\\\": \\\"ContactsPhoneNum_One\\\"}\" "
done

eval $command
