package com.abhishek.dwratelimiter.core.storages.aerospike;

import com.abhishek.dwratelimiter.core.rules.Rule;
import com.abhishek.dwratelimiter.core.factory.StorageFactory;
import com.abhishek.dwratelimiter.core.limiter.aerospike.AerospikeRateLimiter;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Set;

@Singleton
@Slf4j
public class AerospikeFactory implements StorageFactory {

    private final AerospikeConnection aerospikeConnection;
    @Inject
    public AerospikeFactory(AerospikeConnection aerospikeConnection){
        this.aerospikeConnection = aerospikeConnection;
        log.info("Reached the Aerospike Class");

    }

    @Override
    public AerospikeRateLimiter getInstance(Set<Rule> rules) {
        log.info("Came to Aerospike getInstance Class");
        return new AerospikeRateLimiter(aerospikeConnection.client(),rules);
    }

    @Override
    public void close() throws IOException {
        log.info("CLose Aerospike");
    }

}
