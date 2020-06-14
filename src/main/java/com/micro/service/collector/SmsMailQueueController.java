package com.micro.service.collector;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/smsMailQueue")
@RefreshScope
public class SmsMailQueueController {

    private final SmsMailQueueService service;

    public SmsMailQueueController(
            SmsMailQueueService service) {
        this.service = service;
    }

    @PutMapping("/sendInfo")
    @HystrixCommand
    public void sendInfo(@RequestBody CustomerDto customerDto) {
        service.convertAndSend(customerDto);
    }

    @PutMapping("/sendSms")
    @HystrixCommand
    public void sendSms(@RequestBody CustomerDto customerDto) {
        service.convertAndSendToSms(customerDto);
    }
}
