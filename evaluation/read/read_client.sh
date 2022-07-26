#!/bin/bash

DIR=$(dirname "${BASH_SOURCE[0]}")

if [ $# -ne 1 ]; then
    echo "usage: host ";
    exit 1;
fi

clientID="read_client#$( date +'%F|%H:%M')"
rm -f ${clientID}.dat
host=$1
#ncalls=$2

echo "n_calls runtime(s) latency(ms) throughput(ops/s)" >> ${clientID}.dat

for ncalls in 100 200 300 400 500 800 1000 2000 5000
do
  runtime=0
  runtime=$({ time ${DIR}/read_request.sh ${host} ${ncalls}; } 2>&1 |grep real | sed -E 's/[^0-9\.]+//g' | tr -d '\n')


  latency=$( echo "scale=5; ($runtime / $ncalls) * 1000" | bc -l )
  throughput=$( echo "scale=5; 1000 / $latency" | bc -l )

  echo "${ncalls} ${runtime} ${latency} ${throughput}" >> ${clientID}.dat
done



