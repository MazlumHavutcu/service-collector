package com.micro.service.collector;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SmsMailQueueService {

    public final RabbitTemplate rabbitTemplate;

    public SmsMailQueueService(
            RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void convertAndSend(CustomerDto customerDto) {
        this.rabbitTemplate.convertAndSend(RabbitConfiguration.exchange, RabbitConfiguration.routingKey, customerDto);
    }

    public void convertAndSendToSms(CustomerDto customerDto) {
        this.rabbitTemplate.convertAndSend(RabbitConfiguration.smsQueue, customerDto);
    }
}
