package com.abhishek.dwratelimiter.core.storages.aerospike.limiter;

import com.abhishek.dwratelimiter.core.rateLimiters.RateLimiterMethods;

public class AerospikeRateLimiter implements RateLimiterMethods {

    @Override
    public boolean isOverLimit(String key, int weight) {
        return false;
    }
}
