package com.abhishek.dwratelimiter.core.storages.aerospike;

import com.abhishek.dwratelimiter.core.factory.helpers.AbstractBaseFactory;
import com.abhishek.dwratelimiter.core.factory.helpers.StorageType;
import com.abhishek.dwratelimiter.core.factory.helpers.annotation.RateLimiter;
import com.abhishek.dwratelimiter.core.storages.aerospike.limiter.AerospikeRateLimiter;
import com.google.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Singleton
@Slf4j
@RateLimiter(storageType = StorageType.AEROSPIKE)
public class AerospikeFactory extends AbstractBaseFactory<AerospikeRateLimiter> {

    public AerospikeFactory(){
        log.info("Reached the Aerospike Class");
    }
    @Override
    protected AerospikeRateLimiter createInstance() {
        log.info("Came to Aerospike Create Instance Class");
        return null;
    }

    @Override
    protected AerospikeRateLimiter lookupInstance() {
        log.info("Came to Aerospike lookupInstance class");
        return null;
    }

    @Override
    public void getInstance() {
        log.info("Came to Aerospike getInstance Class");
    }

    @Override
    public void close() throws IOException {
        log.info("CLose Aerospike");
    }
}
