package com.example.studentManagement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


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

    @Bean
    public StudentServiceImplement save() { return new StudentServiceImplement();}



}
