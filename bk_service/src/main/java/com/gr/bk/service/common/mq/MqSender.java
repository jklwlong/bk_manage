package com.gr.bk.service.common.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Binding.DestinationType;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;


@Component
@EnableRabbit
public class MqSender {
    private final AmqpAdmin amqpAdmin;
    private final RabbitTemplate rabbitTemplate;
    private final static Logger logger = LoggerFactory.getLogger(MqSender.class);

    @Autowired
    public MqSender(AmqpAdmin amqpAdmin, RabbitTemplate rabbitTemplate) {
        this.amqpAdmin = amqpAdmin;
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * 发送消息-文本
     *
     * @param queueName
     * @param msg
     */
    public void sendDirect(String queueName, String msg) {
        try {
            logger.info("发送direct方式的数据,队列名称={},发送内容={}", queueName, msg);
            String exchangeName = queueName;
            DirectExchange directExchange = new DirectExchange(exchangeName);
            Queue queue = new Queue(queueName);
            amqpAdmin.declareExchange(directExchange);
            amqpAdmin.declareQueue(queue);
            amqpAdmin.declareBinding(new Binding(queueName, DestinationType.QUEUE, exchangeName, queueName, null));
            rabbitTemplate.convertAndSend(queueName, msg);
        } catch (Exception e) {
            logger.error(e.getStackTrace().toString());
        }
    }

    /**
     * 发送topic方式的数据，包含以下2种功能： 1、设置queueName与exchangeName的bindingKey，如：
     * sendTopic(“queueName”, “exchangeName”, “o”,“aa.#”)
     * 2、通过routingKey与exchangeName定位到匹配的queue，如： sendTopic(“”, “exchangeName”,
     * “o”,“aa.zz.bb”)
     *
     * @param queueName             队列名称
     * @param exchangeName          交换器名称
     * @param o                     数据
     * @param routingKey/bindingKey 路由键/选择键
     */
    public void sendTopic(String queueName, String exchangeName, Object o, String routingKey) {
        String msg = JSON.toJSONString(o);
        logger.info("发送topic方式的数据,queueName={},exchangeName={},发送内容={},routingKey={}", queueName, exchangeName, msg, routingKey);
        TopicExchange topicExchange = new TopicExchange(exchangeName);
        amqpAdmin.declareExchange(topicExchange);
        amqpAdmin.declareQueue(new Queue(queueName));
        amqpAdmin.declareBinding(new Binding(queueName, DestinationType.QUEUE, exchangeName, routingKey, null));
        rabbitTemplate.convertAndSend(exchangeName, routingKey, msg);
    }

}