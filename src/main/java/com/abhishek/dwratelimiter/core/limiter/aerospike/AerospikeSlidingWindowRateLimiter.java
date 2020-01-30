package com.abhishek.dwratelimiter.core.limiter.aerospike;

import com.abhishek.dwratelimiter.core.aerospike.AerospikeCommands;
import com.abhishek.dwratelimiter.core.limiter.RateLimiterMethods;
import com.abhishek.dwratelimiter.core.limiter.visitor.RateLimitingVisitor;
import com.abhishek.dwratelimiter.core.config.rules.Rule;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;


@Slf4j
@Getter
public class AerospikeSlidingWindowRateLimiter implements RateLimiterMethods {
    private final AerospikeCommands aerospikeCommands;
    private final Set<Rule> rules;

    public AerospikeSlidingWindowRateLimiter(AerospikeCommands aerospikeCommands, Set<Rule> rules){
        this.aerospikeCommands = aerospikeCommands;
        this.rules = rules;
        log.info("Aerospike Ratelimiter class");
    }
    @Override
    public boolean isOverLimit(String key, int weight, RateLimitingVisitor vistor) {
        log.info("Aerospike Instance of the class");
        log.info(rules.toString());
        log.info(String.valueOf(aerospikeCommands));
        vistor.visit(this);
        return false;
    }
}
