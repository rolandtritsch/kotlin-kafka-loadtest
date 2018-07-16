#!/usr/bin/env bash

echo "Zookeeper start ..."
zookeeper-server-start.sh -daemon config/zookeeper.properties
sleep 5

echo "Kafka start ..."
kafka-server-start.sh -daemon config/server.properties
sleep 5

echo "Create topic(s) ..."
kafka-topics.sh --zookeeper localhost:2181 --create --topic test --partitions 1 -replication-factor 1
