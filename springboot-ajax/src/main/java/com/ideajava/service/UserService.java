package com.ideajava.service;

import com.ideajava.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by rason on 4/12/17.
 */
@Service
public class UserService {

    private List<User> users;

    // Love Java 8
    public List<User> findByUserNameOrEmail(String username) {

        List<User> result = users.stream()
                .filter(x -> x.getUsername().equalsIgnoreCase(username))
                .collect(Collectors.toList());

        return result;

    }

    // Init some users for testing
    @PostConstruct
    private void iniDataForTesting() {

        users = new ArrayList<User>();

        User user1 = new User("ideajava111", "password111", "ideajava111@yahoo.com");
        User user2 = new User("ideajava222", "password222", "ideajava222@yahoo.com");
        User user3 = new User("ideajava333", "password333", "ideajava333@yahoo.com");

        users.add(user1);
        users.add(user2);
        users.add(user3);

    }
}
