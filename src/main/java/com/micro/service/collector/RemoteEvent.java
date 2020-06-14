package com.micro.service.collector;

import org.springframework.context.ApplicationEvent;

public class RemoteEvent extends ApplicationEvent {

    private String message;

    public RemoteEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}