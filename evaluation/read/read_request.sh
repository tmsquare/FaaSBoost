#!/bin/sh

if [ $# -ne 2 ]; then
    echo "usage: OPENFAAS_URL ncalls";
    exit 1;
fi

ncalls=$2
command="curl  -L http://$1:31112/function/get-user-by-userid-filestore/accountId/4d2a46c7-71cb-4cf1-b5bb-b68406d9da6a"

idList=("4d2a46c7-71cb-4cf1-b5bb-b68406d9da6a" "4d2a46c7-71cb-4cf1-b5bb-b68406d9da6b" "4d2a46c7-71cb-4cf1-b5bb-b68406d9da6c" "4d2a46c7-71cb-4cf1-b5bb-b68406d9da6d" "4d2a46c7-71cb-4cf1-b5bb-b68406d9da6e" "4d2a46c7-71cb-4cf1-b5bb-b68406d9da6f")
id=${idList[ $RANDOM % ${#idList[@]} ]}

for i in `seq 2 ${ncalls}`
do
  command=${command}" -: http://$1:31112/function/get-user-by-userid-filestore/accountId/$id"
done

eval $command