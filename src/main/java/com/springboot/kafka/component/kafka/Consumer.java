/**
 * Copyright (C), 2015-2017, tsfa
 * FileName: Consumer.java
 * Author:   chin
 * Date:     2018/8/22    下午5:05
 * Description:
 * History: 修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名     修改时间      版本号        描述
 */
package com.springboot.kafka.component.kafka;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    public static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "${spring.kafka.template.default-topic}")
    public void receive(String payload) {

        //do something......
        LOGGER.info("接收到消息:[{}]", payload);

    }
}
