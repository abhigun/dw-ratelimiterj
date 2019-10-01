package com.abhishek.dwratelimiter.core.storages.redis.limiter;

import com.abhishek.dwratelimiter.core.rateLimiters.RateLimiterMethods;
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
