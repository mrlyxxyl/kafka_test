package com.yx.service;

import com.yx.constant.KafkaProperties;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.Properties;

public class KafkaProducer extends Thread {
    private final kafka.javaapi.producer.Producer<Integer, String> producer;
    private final String topic;
    private final Properties props = new Properties();

    public KafkaProducer(String topic) {
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("metadata.broker.list", KafkaProperties.BROKER_LIST);
        props.put("request.required.acks", "1");
        producer = new kafka.javaapi.producer.Producer<Integer, String>(new ProducerConfig(props));
        this.topic = topic;
    }

    @Override
    public void run() {
        int messageNo = 1;
        while (true) {
            String messageStr = new String("Message_" + messageNo);
            System.out.println("Send:" + messageStr);
            producer.send(new KeyedMessage<Integer, String>(topic, messageStr));
            messageNo++;
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}