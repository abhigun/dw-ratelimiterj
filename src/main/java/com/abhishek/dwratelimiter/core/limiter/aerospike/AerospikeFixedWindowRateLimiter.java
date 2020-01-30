package com.abhishek.dwratelimiter.core.limiter.aerospike;

import com.abhishek.dwratelimiter.core.aerospike.AerospikeCommands;
import com.abhishek.dwratelimiter.core.limiter.RateLimiterMethods;
import com.abhishek.dwratelimiter.core.limiter.visitor.RateLimitingVisitor;
import com.abhishek.dwratelimiter.core.config.rules.Rule;
import lombok.Getter;

import java.util.Set;

@Getter
public class AerospikeFixedWindowRateLimiter implements RateLimiterMethods {
    private final AerospikeCommands aerospikeCommands;
    private final Set<Rule> rules;

    public AerospikeFixedWindowRateLimiter(AerospikeCommands aerospikeCommands, Set<Rule> rules){
        this.aerospikeCommands = aerospikeCommands;
        this.rules = rules;
    }
    @Override
    public boolean isOverLimit(String key, int weight, RateLimitingVisitor vistor) {
        return vistor.visit(this);
    }
}
