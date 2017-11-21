# Spring boot kafka PoC

## Requirements
1. Download https://www.apache.org/dyn/closer.cgi?path=/kafka/1.0.0/kafka_2.11-1.0.0.tgz
```
> tar -xzf kafka_2.11-1.0.0.tgz
> cd kafka_2.11-1.0.0
```
2. Start ZooKeeper
```
> bin/zookeeper-server-start.sh config/zookeeper.properties
```
3. Start Kafka
```
> bin/kafka-server-start.sh config/server.properties
```

## Endpoints
* /api/produces?message=<Your message>
  * Send one message to Kafka topic 
* /api/consumes
  * Read all messages received and clean the in-memory storage. 