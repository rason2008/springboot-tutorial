package com.ideajava.model;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by rason on 4/12/17.
 */
public class SearchCriteria {

    @NotBlank(message = "username can't empty!")
    String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
