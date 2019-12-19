package com.abhishek.dwratelimiter.core.limiter.aerospike;

import com.abhishek.dwratelimiter.core.limiter.RateLimiterMethods;
import com.abhishek.dwratelimiter.core.limiter.visitor.RateLimitingVistor;
import com.abhishek.dwratelimiter.core.rules.Rule;
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
    public boolean isOverLimit(String key, int weight, RateLimitingVistor vistor) {
        log.info("Aerospike Instance of the class");
        log.info(rules.toString());
        log.info(String.valueOf(aerospikeClient.isConnected()));
        vistor.visit(this);
        return false;
    }
}
