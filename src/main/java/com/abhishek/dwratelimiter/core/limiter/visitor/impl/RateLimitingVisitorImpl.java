package com.abhishek.dwratelimiter.core.limiter.visitor.impl;

import com.abhishek.dwratelimiter.core.limiter.aerospike.AerospikeSlidingWindowRateLimiter;
import com.abhishek.dwratelimiter.core.limiter.redis.RedisSlidingWindowRateLimiter;
import com.abhishek.dwratelimiter.core.limiter.visitor.RateLimitingVistor;

public class RateLimitingVisitorImpl implements RateLimitingVistor {
    @Override
    public boolean visit(AerospikeSlidingWindowRateLimiter aerospikeSlidingWindowRateLimiter) {
        return false;
    }

    @Override
    public boolean visit(RedisSlidingWindowRateLimiter redisSlidingWindowRateLimiter) {
        return false;
    }
}
