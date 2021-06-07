package com.edaoren.event;

import cn.hutool.core.date.DateUtil;
import com.edaoren.event.message.TestMessage;
import com.edaoren.event.amqp.TestAmqpEvent;
import com.edaoren.event.publisher.AmqpEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.temporal.ChronoUnit;
import java.util.Date;

@Slf4j
@SpringBootTest
class RabbitmqSpringEventApplicationTests {

    @Autowired
    private AmqpEventPublisher amqpEventPublisher;

    /*@Autowired
    private SpringEventPublisher publisher;*/

    @Autowired
    private AmqpTemplate amqpTemplate;


    /*@Test
    public void spring(){
        log.info("begin >>>>>>");
        TestMessage message = TestMessage.builder().content("我是测试消息").build();
        publisher.publish(new TestSpringEvent(message));
        log.info("end >>>>>>");
    }*/

    @Test
    public void mq() {
        log.info("发送测试消息, 时间：{}", DateUtil.formatDateTime(new Date()));
        amqpEventPublisher.publish(new TestAmqpEvent(TestMessage.builder().content("测试消息").build()),
                10L, ChronoUnit.SECONDS, false);
    }

    @Test
    public void ack() {
        for (int i = 0; i < 10; i++) {
            amqpTemplate.convertAndSend("test-ack-exchange", "test-ack-query", i);
        }
    }
}
