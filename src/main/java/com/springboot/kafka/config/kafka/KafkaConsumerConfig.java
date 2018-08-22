/**
 * Copyright (C), 2015-2017, tsfa
 * FileName: KafkaConsumerConfig.java
 * Author:   chin
 * Date:     2018/8/22    下午5:08
 * Description:
 * History: 修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名     修改时间      版本号        描述
 */
package com.springboot.kafka.config.kafka;


import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Kafka consumer Config class<br>
 * 〈功能详细描述〉
 *
 * @author Chin
 * @since 1.0
 */
@Configuration
public class KafkaConsumerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootStrapServers;

    @Value("${spring.kafka.consumer.group-id}")
    private String consumerGroupId;

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        Map<String, Object> prop = new HashMap<>();

        prop.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServers);
        prop.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        prop.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        prop.put(ConsumerConfig.GROUP_ID_CONFIG, consumerGroupId);

        return new DefaultKafkaConsumerFactory<>(prop);
    }

    @Bean
    public KafkaListenerContainerFactory kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }


}
