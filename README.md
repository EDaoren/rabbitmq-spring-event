# rabbitmq-spring-event

记录Spring boot 整合 RabbitMq 和 Spring Event 学习例子，支持设置当前是否提交后提交

RabbitMq 使用

- 编写Mq 使用的消息体 `TestMessage`
- 编写 `TestAmqpEvent`，定时业务使用的交换机 EXCHANGE 、 QUEUE、 ROUTING_KEY 等
- 编写 `TestRabbitListener` Mq监听，实现响应的业务

测试：
```
    
    @Autowired
    private AmqpEventPublisher amqpEventPublisher;

    amqpEventPublisher.publish(new TestAmqpEvent(TestMessage.builder().content("测试消息").build()),
    10L, ChronoUnit.SECONDS, true);
```

Spring Event 使用

- 编写Mq 使用的消息体 `TestMessage`
- 编写 `TestSpringEvent` 
- 编写 `TestSpringListener` Mq监听，实现响应的业务

测试：
```
    @Autowired
    private SpringEventPublisher springEventPublisher;

    springEventPublisher.publish(new TestSpringEvent(TestMessage.builder().content("测试消息").build()));
```
