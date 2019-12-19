package com.abhishek.dwratelimiter.core.limiter.visitor;

import com.abhishek.dwratelimiter.core.limiter.aerospike.AerospikeFixedWindowRateLimiter;
import com.abhishek.dwratelimiter.core.limiter.aerospike.AerospikeSlidingWindowRateLimiter;
import com.abhishek.dwratelimiter.core.limiter.redis.RedisFixedWindowRateLimiter;
import com.abhishek.dwratelimiter.core.limiter.redis.RedisSlidingWindowRateLimiter;

public interface RateLimitingVistor {
    boolean visit(AerospikeSlidingWindowRateLimiter aerospikeSlidingWindowRateLimiter);
    boolean visit(AerospikeFixedWindowRateLimiter aerospikeFixedWindowRateLimiter);
    boolean visit(RedisSlidingWindowRateLimiter redisSlidingWindowRateLimiter);
    boolean visit(RedisFixedWindowRateLimiter redisFixedWindowRateLimiter);
}
