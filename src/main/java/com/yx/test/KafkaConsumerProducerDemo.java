package com.yx.test;

import com.yx.constant.KafkaProperties;
import com.yx.service.KafkaConsumer;
import com.yx.service.KafkaProducer;
import org.junit.Test;

import java.io.IOException;

public class KafkaConsumerProducerDemo {
    @Test
    public void testProducer() throws IOException {
        KafkaProducer producerThread = new KafkaProducer(KafkaProperties.topic);
        producerThread.start();
        System.in.read();
    }

    @Test
    public void testConsumer() throws IOException {
        KafkaConsumer consumerThread = new KafkaConsumer(KafkaProperties.topic);
        consumerThread.start();
        System.in.read();
    }
}