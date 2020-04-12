package com.project.world.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyBean implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
        // Do something...
    }
}
