package com.abhishek.dwratelimiter.core.limiter.redis;

import com.abhishek.dwratelimiter.core.limiter.RateLimiterMethods;
import com.abhishek.dwratelimiter.core.limiter.visitor.RateLimitingVisitor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RedisSlidingWindowRateLimiter implements RateLimiterMethods {
    public RedisSlidingWindowRateLimiter(){
        log.info("Redis Rate Limiter Class");
    }
    @Override
    public boolean isOverLimit(String key, int weight, RateLimitingVisitor vistor) {
        log.info("Redis Method Rate Limiter");
        return false;
    }
}
