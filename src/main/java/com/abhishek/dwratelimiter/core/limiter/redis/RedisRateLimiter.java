package com.abhishek.dwratelimiter.core.limiter.redis;

import com.abhishek.dwratelimiter.core.limiter.RateLimiterMethods;
import com.google.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Singleton
@Slf4j
public class RedisRateLimiter implements RateLimiterMethods {
    public RedisRateLimiter(){
        log.info("Redis Rate Limiter Class");
    }
    @Override
    public boolean isOverLimit(String key, int weight) {
        log.info("Redis Method Rate Limiter");
        return false;
    }
}
