package com.example.studentManagement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config {

    @Bean
    public RegisterForm register(){
        return new RegisterForm();
    }

    @Bean
    public LoginForm login(){
        return new LoginForm();
    }



}
