package com.ideajava;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created by rason on 4/12/17.
 */
@Component
@ConfigurationProperties // no prefix, find root level values.
public class GlobalPropertiesComplex {

    @Min(0)
    @Max(5)
    private int threadPool;

    @NotEmpty
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

    @Override
    public String toString() {
        return "GlobalPropertiesComplex{" +
                "threadPool=" + threadPool +
                ", email='" + email + '\'' +
                '}';
    }
}
