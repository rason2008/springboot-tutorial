package com.ideajava;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by rason on 4/12/17.
 */
@Component
@PropertySource("classpath:global.properties")
@ConfigurationProperties
public class GlobalPropertiesConf {

    private int threadPool;
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
