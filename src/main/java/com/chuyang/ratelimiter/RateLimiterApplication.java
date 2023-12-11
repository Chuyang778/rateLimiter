package com.chuyang.ratelimiter;

import com.chuyang.ratelimiter.annotation.AccessInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Retention;

@Slf4j
@SpringBootApplication
@Configurable
@RestController()
@RequestMapping("/api/ratelimiter")
public class RateLimiterApplication {

    public static void main(String[] args) {
        SpringApplication.run(RateLimiterApplication.class, args);
    }


    @AccessInterceptor(key = "fingerprint", fallbackMethod = "loginErr", permitsPersecond = 1.0d, blacklistCount = 10)
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(String fingerprint, String uId, String token) {
        log.info("模拟登录 fingerprint:{}", fingerprint);
        return "模拟登录：登录成功 " + uId;
    }
    public String loginErr(String fingerprint, String uId, String token) {
        return "频次限制，请勿恶意访问！";
    }

}
