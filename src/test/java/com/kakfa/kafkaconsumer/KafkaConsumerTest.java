package com.kakfa.kafkaconsumer;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@DirtiesContext
public class KafkaConsumerTest {
    private static final String RECEIVER_TOPIC = "message-ack";
    private static final String MESSAGE = "Hello";

    @Autowired
    private KafkaConsumer kafkaConsumer;

    @ClassRule
    public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, true, RECEIVER_TOPIC);

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void kafkaListenerWithAck_expectSystemOutPrintSameWithMessage() {
        Acknowledgment acknowledgment = mock(Acknowledgment.class);

        kafkaConsumer.kafkaListenerWithAck(MESSAGE, acknowledgment);

        String expect = "Received message: "+MESSAGE+"\n";

        Assert.assertEquals(expect, outContent.toString());
        verify(acknowledgment, times(1));
    }
}
