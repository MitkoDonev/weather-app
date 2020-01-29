package com.mitkodonev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

@Configuration
public class CustomConfig {

    @Bean
    public IDialect conditionalCommentDialect() {
        return new Java8TimeDialect();
    }
}
