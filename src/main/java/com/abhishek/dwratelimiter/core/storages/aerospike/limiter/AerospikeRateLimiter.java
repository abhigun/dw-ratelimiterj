package com.abhishek.dwratelimiter.core.storages.aerospike.limiter;

import com.abhishek.dwratelimiter.core.RateLimiterMethods;
import com.google.inject.Singleton;
import lombok.extern.slf4j.Slf4j;


@Singleton
@Slf4j
public class AerospikeRateLimiter implements RateLimiterMethods {

    public AerospikeRateLimiter(){
        log.info("Aerospike Ratelimiter class");
    }
    @Override
    public boolean isOverLimit(String key, int weight) {
        log.info("Aerospike Instance of the class");
        return false;
    }
}
