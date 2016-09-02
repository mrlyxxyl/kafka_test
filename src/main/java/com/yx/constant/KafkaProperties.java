package com.yx.constant;

public interface KafkaProperties {
    final static String zkConnect = "192.168.10.156:2181,192.168.10.157:2181,192.168.10.158:2181";
    final static String groupId = "test-consumer-group";
    final static String topic = "my_new_topic";
    final static String BROKER_LIST = "192.168.10.156:9092,192.168.10.157:9092,192.168.10.158:9092";
}