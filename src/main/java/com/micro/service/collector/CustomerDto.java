package com.micro.service.collector;

import lombok.Data;

@Data
public class CustomerDto {

    private long id;

    private String name;

    private String address;

    private String email;

    private String phoneNumber;

}
