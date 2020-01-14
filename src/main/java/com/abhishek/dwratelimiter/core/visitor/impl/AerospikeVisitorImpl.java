package com.abhishek.dwratelimiter.core.visitor.impl;

import com.abhishek.dwratelimiter.core.limiter.RateLimiterMethods;
import com.abhishek.dwratelimiter.core.limiter.aerospike.AerospikeFixedWindowRateLimiter;
import com.abhishek.dwratelimiter.core.limiter.aerospike.AerospikeSlidingWindowRateLimiter;
import com.abhishek.dwratelimiter.core.rules.Rule;
import com.abhishek.dwratelimiter.aerospike.AerospikeConnection;
import com.abhishek.dwratelimiter.core.visitor.LimiterTypeVisitor;

import java.util.Set;

public class AerospikeVisitorImpl implements LimiterTypeVisitor<RateLimiterMethods> {
    private final AerospikeConnection aerospikeConnection;
    private final Set<Rule> rules;
    public AerospikeVisitorImpl(AerospikeConnection aerospikeConnection, Set<Rule> rules){
        this.aerospikeConnection = aerospikeConnection;
        this.rules = rules;
    }

    @Override
    public RateLimiterMethods getSlidingWindowLimiter() {
        return new AerospikeSlidingWindowRateLimiter(aerospikeConnection.client(),rules);
    }

    @Override
    public RateLimiterMethods getFixedWindowLimiter() {
        return new AerospikeFixedWindowRateLimiter(aerospikeConnection.client(),rules);
    }
}
