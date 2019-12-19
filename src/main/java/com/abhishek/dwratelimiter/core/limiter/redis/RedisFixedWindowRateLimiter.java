package com.abhishek.dwratelimiter.core.limiter.redis;

import com.abhishek.dwratelimiter.core.limiter.RateLimiterMethods;
import com.abhishek.dwratelimiter.core.limiter.visitor.RateLimitingVistor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RedisFixedWindowRateLimiter implements RateLimiterMethods {
    public RedisFixedWindowRateLimiter(){
        log.info("Redis Fixed Window rate Limiter");
    }
    @Override
    public boolean isOverLimit(String key, int weight, RateLimitingVistor vistor) {
        return false;
    }
}
