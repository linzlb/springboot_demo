package com.linzlb.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value="kafka Controller", tags={"kafka接口"})
@RestController
@RequestMapping("/kafka")
public class KafkaProducer {

    private Logger logger=Logger.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    // 发送消息
    @ApiOperation(value = "生产者发消息", notes = "生产者发消息")
    @GetMapping("/normal/{message}")
    public void sendMessage1(@PathVariable("message") String normalMessage) {
        kafkaTemplate.send("topic1", normalMessage);
    }


    // 带回调的生产者
    // kafkaTemplate提供了一个回调方法addCallback，我们可以在回调方法中监控消息是否发送成功
    // 或 失败时做补偿处理，有下面两种写法，
    @ApiOperation(value = "生产者发消息", notes = "生产者发消息")
    @GetMapping("/callbackOne/{message}")
    public void sendMessage2(@PathVariable("message") String callbackMessage) {
        kafkaTemplate.send("topic1", callbackMessage).addCallback(success -> {
            // 消息发送到的topic
            String topic = success.getRecordMetadata().topic();
            // 消息发送到的分区
            int partition = success.getRecordMetadata().partition();
            // 消息在分区内的offset
            long offset = success.getRecordMetadata().offset();
            logger.info("发送消息成功:" + topic + "-" + partition + "-" + offset);
        }, failure -> {
            logger.info("发送消息失败:" + failure.getMessage());
        });
    }
    @ApiOperation(value = "生产者发消息", notes = "生产者发消息")
    @GetMapping("/callbackTwo/{message}")
    public void sendMessage3(@PathVariable("message") String callbackMessage) {
        kafkaTemplate.send("topic1", callbackMessage).addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("发送消息失败："+ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                System.out.println("发送消息成功：" + result.getRecordMetadata().topic() + "-"
                        + result.getRecordMetadata().partition() + "-" + result.getRecordMetadata().offset());
            }
        });
    }


    //kafka事务提交
    //如果在发送消息时需要创建事务，可以使用 KafkaTemplate 的 executeInTransaction 方法来声明事务
    @GetMapping("/kafka/transaction")
    public void sendMessage7(){
        // 1声明事务：后面报错消息不会发出去
        kafkaTemplate.executeInTransaction(operations -> {
            operations.send("topic1","test executeInTransaction");
            throw new RuntimeException("fail");
        });
        // 2不声明事务：后面报错但前面消息已经发送成功了
        kafkaTemplate.send("topic1","test executeInTransaction");
        throw new RuntimeException("fail");
    }


    //消息过滤/转发 等各种操作都看readme文件 SpringBoot集成kafka全面实战
}