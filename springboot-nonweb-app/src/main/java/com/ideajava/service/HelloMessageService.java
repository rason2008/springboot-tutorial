package com.ideajava.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by ideajava on 4/12/17.
 */
@Service
public class HelloMessageService {

    @Value("${name:unknown}")
    private String name;

    public String getMessage() {
        return getMessage(name);
    }

    public String getMessage(String name) {
        return "Hello " + name;
    }

}
