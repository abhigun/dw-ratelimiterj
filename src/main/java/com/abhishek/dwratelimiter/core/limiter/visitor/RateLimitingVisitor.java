package com.abhishek.dwratelimiter.core.limiter.visitor;

import com.abhishek.dwratelimiter.core.limiter.aerospike.AerospikeFixedWindowRateLimiter;
import com.abhishek.dwratelimiter.core.limiter.aerospike.AerospikeSlidingWindowRateLimiter;
import com.abhishek.dwratelimiter.core.limiter.redis.RedisFixedWindowRateLimiter;
import com.abhishek.dwratelimiter.core.limiter.redis.RedisSlidingWindowRateLimiter;

public interface RateLimitingVisitor {
    boolean visit(AerospikeSlidingWindowRateLimiter aerospikeSlidingWindowRateLimiter, String key);
    boolean visit(AerospikeFixedWindowRateLimiter aerospikeFixedWindowRateLimiter, String key);
    boolean visit(RedisSlidingWindowRateLimiter redisSlidingWindowRateLimiter, String key);
    boolean visit(RedisFixedWindowRateLimiter redisFixedWindowRateLimiter, String key);
}
