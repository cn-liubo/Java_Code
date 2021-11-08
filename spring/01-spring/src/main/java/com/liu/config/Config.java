package com.liu.config;

import com.liu.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.liu")
public class Config {

    @Bean
    public User user() {
        return new User();
    }
}
