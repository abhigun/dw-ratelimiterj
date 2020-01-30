package com.abhishek.dwratelimiter.annotations;

import com.abhishek.dwratelimiter.core.limiter.LimiterType;

import javax.ws.rs.NameBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@NameBinding
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ThrottleRule {
    int duration();
    int precision();
    int limit();
    int weight() default 1;
    LimiterType type() default LimiterType.SLIDING;
}
