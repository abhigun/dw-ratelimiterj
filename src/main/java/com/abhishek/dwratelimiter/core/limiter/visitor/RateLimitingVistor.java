package com.abhishek.dwratelimiter.core.limiter.visitor;

import com.abhishek.dwratelimiter.core.limiter.aerospike.AerospikeSlidingWindowRateLimiter;
import com.abhishek.dwratelimiter.core.limiter.redis.RedisSlidingWindowRateLimiter;

public interface RateLimitingVistor {
    boolean visit(AerospikeSlidingWindowRateLimiter aerospikeSlidingWindowRateLimiter);
    boolean visit(RedisSlidingWindowRateLimiter redisSlidingWindowRateLimiter);
}
