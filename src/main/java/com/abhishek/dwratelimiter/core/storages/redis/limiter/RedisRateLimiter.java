package com.abhishek.dwratelimiter.core.storages.redis.limiter;

import com.abhishek.dwratelimiter.core.rateLimiters.RateLimiterMethods;

public class RedisRateLimiter implements RateLimiterMethods {
    @Override
    public boolean isOverLimit(String key, int weight) {
        return false;
    }
}
