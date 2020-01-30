package com.abhishek.dwratelimiter.core.storages.aerospike;

import com.abhishek.dwratelimiter.aerospike.AerospikeCommands;
import com.abhishek.dwratelimiter.aerospike.AerospikeConnection;
import com.abhishek.dwratelimiter.core.limiter.RateLimiterMethods;
import com.abhishek.dwratelimiter.core.limiter.aerospike.AerospikeFixedWindowRateLimiter;
import com.abhishek.dwratelimiter.core.limiter.aerospike.AerospikeSlidingWindowRateLimiter;
import com.abhishek.dwratelimiter.core.rules.Rule;
import com.abhishek.dwratelimiter.core.factory.StorageFactory;
import com.abhishek.dwratelimiter.core.visitor.LimiterType;
import com.abhishek.dwratelimiter.core.visitor.LimiterTypeVisitor;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Set;

@Singleton
@Slf4j
public class AerospikeFactory implements StorageFactory {

    private final AerospikeCommands aerospikeCommands;
    @Inject
    public AerospikeFactory(AerospikeCommands aerospikeCommands){
        this.aerospikeCommands = aerospikeCommands;
        log.info("Reached the Aerospike Class");

    }

    @Override
    public RateLimiterMethods getInstance(Set<Rule> rules, LimiterType limiterType) {
        log.info("Came to Aerospike getInstance Class");
        return limiterType.visit(new LimiterTypeVisitor<RateLimiterMethods>() {
            @Override
            public RateLimiterMethods visitSliding() {
                return new AerospikeSlidingWindowRateLimiter(aerospikeCommands,rules);
            }

            @Override
            public RateLimiterMethods visitFixed() {
                return new AerospikeFixedWindowRateLimiter(aerospikeCommands,rules);
            }
        });
    }

    @Override
    public void close() throws IOException {
        log.info("CLose Aerospike");
    }

}
