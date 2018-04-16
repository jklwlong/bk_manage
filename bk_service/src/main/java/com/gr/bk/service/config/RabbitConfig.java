package com.gr.bk.service.config;

import com.gr.bk.service.common.constants.MqNameConstants;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;


@Component
public class RabbitConfig {

    private String host = "localhost";

    private int port = 5673;

    private String username = "guest";

    private String password = "guest";

    @Bean
    public ConnectionFactory setRabbitConnectionFactory() {
        CachingConnectionFactory rabbitConnectionFactory = new CachingConnectionFactory(host, port);
        rabbitConnectionFactory.setUsername(username);
        rabbitConnectionFactory.setPassword(password);
        rabbitConnectionFactory.setVirtualHost("/");
//        rabbitConnectionFactory.setPublisherConfirms(true); //必须要设置
        return rabbitConnectionFactory;
    }

    @Bean
    public RabbitTemplate amqpTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(setRabbitConnectionFactory());
        return rabbitTemplate;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        RabbitAdmin amqpAdmin = new RabbitAdmin(setRabbitConnectionFactory());
        Field[] fields = MqNameConstants.class.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getName().contains("TEST")) {
                try {
                    String queueName = fields[i].get(MqNameConstants.class).toString();
                    amqpAdmin.declareExchange(new DirectExchange(queueName));
                    amqpAdmin.declareQueue(new Queue(queueName));
                    amqpAdmin.declareBinding(new Binding(queueName, Binding.DestinationType.QUEUE, queueName, queueName, null));
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return amqpAdmin;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(setRabbitConnectionFactory());
        return factory;
    }

}
