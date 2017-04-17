package com.ideajava;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by rason on 4/12/17.
 */
@Component
@PropertySource("classpath:global.properties")
public class GlobalProperties {

    @Value("${thread-pool}")
    private int threadPool;

    @Value("${email}")
    private String email;

    public int getThreadPool() {
        return threadPool;
    }

    public void setThreadPool(int threadPool) {
        this.threadPool = threadPool;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
