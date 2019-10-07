package com.abhishek.dwratelimiter.core.storages.aerospike.limiter;

import com.abhishek.dwratelimiter.core.RateLimiterMethods;
import com.abhishek.dwratelimiter.core.Rule;
import com.abhishek.dwratelimiter.core.storages.aerospike.AerospikeConnection;
import com.google.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;


@Singleton
@Slf4j
public class AerospikeRateLimiter implements RateLimiterMethods {
    private final AerospikeConnection aerospikeConnection;
    private final Set<Rule> rules;

    public AerospikeRateLimiter(AerospikeConnection aerospikeConnection, Set<Rule> rules){
        this.aerospikeConnection = aerospikeConnection;
        this.rules = rules;
        log.info("Aerospike Ratelimiter class");
    }
    @Override
    public boolean isOverLimit(String key, int weight) {
        log.info("Aerospike Instance of the class");

        return false;
    }
}
