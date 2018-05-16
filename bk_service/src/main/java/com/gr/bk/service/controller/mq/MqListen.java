package com.gr.bk.service.controller.mq;

import com.gr.bk.service.common.constants.MqNameConstants;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MqListen {
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = MqNameConstants.TEST_QUE_1,autoDelete = "false", durable = "true", exclusive = "false") ,
            exchange = @Exchange(value = MqNameConstants.TEST_QUE_1, autoDelete = "false", durable = "false", type = "direct") ,
            key = MqNameConstants.TEST_QUE_1) )
//@RabbitListener(queues = "TEST_QUE_1")
    public void accessResult(Message message) {
        try {
            String s = new String(message.getBody(),"UTF-8");
            System.out.println("收到消息--------------");
            Thread.sleep(10000);
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
