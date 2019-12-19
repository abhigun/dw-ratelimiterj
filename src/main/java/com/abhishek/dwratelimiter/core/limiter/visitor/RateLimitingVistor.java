package com.abhishek.dwratelimiter.core.limiter.visitor;

import com.abhishek.dwratelimiter.core.limiter.aerospike.AerospikeRateLimiter;
import com.abhishek.dwratelimiter.core.limiter.redis.RedisRateLimiter;

public interface RateLimitingVistor {
    boolean visit(AerospikeRateLimiter aerospikeRateLimiter);
    boolean visit(RedisRateLimiter redisRateLimiter);
}
