package com.ideajava;

import com.ideajava.service.HelloMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.System.exit;

/**
 * Created by ideajava on 4/12/17.
 */
@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

    @Autowired
    private HelloMessageService helloService;

    public static void main(String[] args) {
        //disabled banner, don't want to see the spring logo
        SpringApplication application = new SpringApplication(SpringBootConsoleApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length > 0) {
            System.out.println(helloService.getMessage(args[0].toString()));
        } else {
            System.out.println(helloService.getMessage());
        }

        exit(0);
    }
}
