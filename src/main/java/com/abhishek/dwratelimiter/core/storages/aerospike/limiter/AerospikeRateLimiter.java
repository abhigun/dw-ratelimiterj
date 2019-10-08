package com.abhishek.dwratelimiter.core.storages.aerospike.limiter;

import com.abhishek.dwratelimiter.core.RateLimiterMethods;
import com.abhishek.dwratelimiter.core.Rule;
import com.abhishek.dwratelimiter.core.storages.aerospike.AerospikeConnection;
import com.aerospike.client.AerospikeClient;
import com.google.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;


@Singleton
@Slf4j
public class AerospikeRateLimiter implements RateLimiterMethods {
    private final AerospikeClient aerospikeClient;
    private final Set<Rule> rules;

    public AerospikeRateLimiter(AerospikeClient aerospikeClient, Set<Rule> rules){
        this.aerospikeClient = aerospikeClient;
        this.rules = rules;
        log.info("Aerospike Ratelimiter class");
    }
    @Override
    public boolean isOverLimit(String key, int weight) {
        log.info("Aerospike Instance of the class");
        log.info(rules.toString());
        log.info(String.valueOf(aerospikeClient.isConnected()));
        return false;
    }
}
