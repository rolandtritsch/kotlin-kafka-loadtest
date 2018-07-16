#!/usr/bin/env bash

echo "Delete topic(s) ..."
kafka-topics.sh --zookeeper localhost:2181 --delete --topic test
sleep 5

echo "Stop kafka ..."
kafka-server-stop.sh
sleep 5

echo "Stop zookeeper ..."
zookeeper-server-stop.sh
