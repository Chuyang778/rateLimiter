package com.chuyang.ratelimiter.config;


import com.chuyang.ratelimiter.aop.RateLimiterAOP;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class RateLimiterAOPConfig {

    @Bean
    public RateLimiterAOP rateLimiter(){
        return new RateLimiterAOP();
    }

}
