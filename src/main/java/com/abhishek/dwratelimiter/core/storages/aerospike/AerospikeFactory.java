package com.abhishek.dwratelimiter.core.storages.aerospike;

import com.abhishek.dwratelimiter.core.Rule;
import com.abhishek.dwratelimiter.core.factory.helpers.AbstractBaseFactory;
import com.abhishek.dwratelimiter.utils.StorageType;
import com.abhishek.dwratelimiter.core.factory.helpers.annotation.RateLimiter;
import com.abhishek.dwratelimiter.core.storages.aerospike.limiter.AerospikeRateLimiter;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Set;

@Singleton
@Slf4j
@RateLimiter(storageType = StorageType.AEROSPIKE)
public class AerospikeFactory extends AbstractBaseFactory<AerospikeRateLimiter> {

    private final AerospikeConnection aerospikeConnection;
    @Inject
    public AerospikeFactory(AerospikeConnection aerospikeConnection){
        this.aerospikeConnection = aerospikeConnection;
        log.info("Reached the Aerospike Class");

    }

    @Override
    protected AerospikeRateLimiter createInstance(Set<Rule> rules) {
        log.info(String.valueOf(aerospikeConnection.client().isConnected()));
        return new AerospikeRateLimiter(aerospikeConnection.client(),rules);
    }


    @Override
    public AerospikeRateLimiter getInstance(Set<Rule> rules) {
        log.info("Came to Aerospike getInstance Class");
        return lookupInstance(rules);

    }

    @Override
    public void close() throws IOException {
        log.info("CLose Aerospike");
    }

}
