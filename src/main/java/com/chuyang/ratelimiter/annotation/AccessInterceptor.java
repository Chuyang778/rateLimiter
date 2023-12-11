package com.chuyang.ratelimiter.annotation;

import java.lang.annotation.*;

/**
 * @author ChuYang
 * @version 1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface AccessInterceptor {

    String key() default "all";

    double permitsPersecond();

    double blacklistCount() default 0;

    String fallbackMethod();
}
