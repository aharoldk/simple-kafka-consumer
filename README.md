# Kafka Consumer
Apache Kafka is an open source distributed streaming platform capable of handling trillions of events a day. Initially conceived as a messaging queue, Kafka is based on an abstraction of a distributed commit log. Since being created and open sourced by LinkedIn in 2011, Kafka has quickly evolved from messaging queue to a full-fledged streaming platform. Kafka has four core APIs:
  - Producer API
  - Consumer API
  - Streams API
  - Connector API


But in this tutorial i will explain about Kafka Consumer.

## Consumer API
Consumer API allows an application to subscribe to one or more topics in the Kafka cluster and process them messages/records.

to use the consumer we must use maven depedency:
```
<dependency>
    <groupId>org.apache.kafka</groupId>
    <artifactId>kafka-clients</artifactId>
    <version>2.0.0</version>
</dependency>
```

and you can follow rest of tutorial in [www.aharoldk.com]

 [www.aharoldk.com]: <https://aharoldk.com>