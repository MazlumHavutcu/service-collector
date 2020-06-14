package com.micro.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableDiscoveryClient
@RemoteApplicationEventScan
@EnableHystrix
public class ServiceCollectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceCollectorApplication.class, args);
    }

}
