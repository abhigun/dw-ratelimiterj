package com.abhishek.dwratelimiter.core.limiter.aerospike;

import com.abhishek.dwratelimiter.core.limiter.RateLimiterMethods;
import com.abhishek.dwratelimiter.core.limiter.visitor.RateLimitingVistor;
import com.abhishek.dwratelimiter.core.rules.Rule;
import com.aerospike.client.AerospikeClient;

import java.util.Set;

public class AerospikeFixedWindowRateLimiter implements RateLimiterMethods {
    private final AerospikeClient aerospikeClient;
    private final Set<Rule> rules;

    public AerospikeFixedWindowRateLimiter(AerospikeClient aerospikeClient, Set<Rule> rules){
        this.aerospikeClient = aerospikeClient;
        this.rules = rules;
    }
    @Override
    public boolean isOverLimit(String key, int weight, RateLimitingVistor vistor) {
        return vistor.visit(this);
    }
}
