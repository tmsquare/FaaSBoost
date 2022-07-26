#!/bin/sh

if [ $# -ne 2 ]; then
    echo "usage: OPENFAAS_URL ncalls";
    exit 1;
fi

ncalls=$2
command="curl  -L http://$1:31112/function/get-user-by-userid/accountId/4d2a46c7-71cb-4cf1-b5bb-b68406d9da6f"

for i in `seq 2 ${ncalls}`
do
  command=${command}" -: http://$1:31112/function/get-user-by-userid/accountId/4d2a46c7-71cb-4cf1-b5bb-b68406d9da6f"
done

eval $command