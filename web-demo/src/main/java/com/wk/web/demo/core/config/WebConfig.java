package com.wk.web.demo.core.config;


import com.wk.web.demo.core.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {
    @Bean
    public Test webWebConfig() {
        return new Test();
    }
}
