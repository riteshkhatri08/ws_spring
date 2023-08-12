package com.ritesh.springapp.hello.app.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.ritesh.springapp.hello.app.json.Greeting;

@Configuration
public class AppConfig {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Greeting englishGreeting() {
        return new Greeting("Hello, World");
    }

    @Bean
    public Greeting dutchGreeting() {
        return new Greeting("Halo, Welt");
    }
}
