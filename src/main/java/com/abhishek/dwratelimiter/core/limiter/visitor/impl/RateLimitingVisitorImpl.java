package com.abhishek.dwratelimiter.core.limiter.visitor.impl;

import com.abhishek.dwratelimiter.core.limiter.aerospike.AerospikeRateLimiter;
import com.abhishek.dwratelimiter.core.limiter.redis.RedisRateLimiter;
import com.abhishek.dwratelimiter.core.limiter.visitor.RateLimitingVistor;

public class RateLimitingVisitorImpl implements RateLimitingVistor {
    @Override
    public boolean visit(AerospikeRateLimiter aerospikeRateLimiter) {
        return false;
    }

    @Override
    public boolean visit(RedisRateLimiter redisRateLimiter) {
        return false;
    }
}
