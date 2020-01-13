package com.abhishek.dwratelimiter.core.limiter.visitor.impl;

import com.abhishek.dwratelimiter.core.limiter.aerospike.AerospikeFixedWindowRateLimiter;
import com.abhishek.dwratelimiter.core.limiter.aerospike.AerospikeSlidingWindowRateLimiter;
import com.abhishek.dwratelimiter.core.limiter.redis.RedisFixedWindowRateLimiter;
import com.abhishek.dwratelimiter.core.limiter.redis.RedisSlidingWindowRateLimiter;
import com.abhishek.dwratelimiter.core.limiter.visitor.RateLimitingVisitor;

public class RateLimitingVisitorImpl implements RateLimitingVisitor {
    @Override
    public boolean visit(AerospikeSlidingWindowRateLimiter aerospikeSlidingWindowRateLimiter) {
        return false;
    }

    @Override
    public boolean visit(AerospikeFixedWindowRateLimiter aerospikeFixedWindowRateLimiter) {
        return false;
    }

    @Override
    public boolean visit(RedisSlidingWindowRateLimiter redisSlidingWindowRateLimiter) {
        return false;
    }

    @Override
    public boolean visit(RedisFixedWindowRateLimiter redisFixedWindowRateLimiter) {
        return false;
    }
}
