package com.kakfa.kafkaconsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(
            topics = "message",
            containerFactory = "kafkaListenerContainerFactory")
    public void kafkaListener(@Payload String message) {
        System.out.println(message);
    }

    @KafkaListener(
            topics = "message-ack",
            containerFactory = "kafkaListenerWithAckContainerFactory")
    public void greetingListener(@Payload String message, Acknowledgment acknowledgment) {

        System.out.println("Received message: " + message);

        acknowledgment.acknowledge();
    }
}
