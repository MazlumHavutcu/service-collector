package com.micro.service.collector;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    public static final String exchange = "app-exchange";

    public static final String routingKey = "SmsAndMail";

    public static final String smsQueue = "sms-queue";

    public static final String mailQueue = "mail-queue";


    @Bean
    public MessageConverter create() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue getMailQueue() {
        return new Queue(mailQueue);
    }

    @Bean
    public Queue getSmsQueue() {
        return new Queue(smsQueue);
    }


    @Bean
    public TopicExchange getExchange() {
        return new TopicExchange(exchange);
    }


    @Bean
    public Binding declareBindingMail() {
        return BindingBuilder.bind(getMailQueue()).to(getExchange()).with(routingKey);
    }

    @Bean
    public Binding declareBindingSms() {
        return BindingBuilder.bind(getSmsQueue()).to(getExchange()).with(routingKey);
    }

    @Bean
    public RabbitAdmin admin(ConnectionFactory cf) {
        return new RabbitAdmin(cf);
    }
}
