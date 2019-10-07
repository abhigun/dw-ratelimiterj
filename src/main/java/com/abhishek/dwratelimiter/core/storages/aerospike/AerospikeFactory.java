package com.abhishek.dwratelimiter.core.storages.aerospike;

import com.abhishek.dwratelimiter.core.factory.helpers.AbstractBaseFactory;
import com.abhishek.dwratelimiter.core.StorageType;
import com.abhishek.dwratelimiter.core.factory.helpers.annotation.RateLimiter;
import com.abhishek.dwratelimiter.core.storages.aerospike.limiter.AerospikeRateLimiter;
import com.aerospike.client.AerospikeClient;
import com.google.inject.Singleton;
import io.dropwizard.lifecycle.Managed;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Singleton
@Slf4j
@RateLimiter(storageType = StorageType.AEROSPIKE)
public class AerospikeFactory extends AbstractBaseFactory<AerospikeRateLimiter> {

    private static AerospikeClient aerospikeClient;

    public AerospikeFactory(){
        log.info("Reached the Aerospike Class");
    }

    @Override
    protected AerospikeRateLimiter createInstance() {
        log.info("Came to Aerospike Create Instance Class");
        return new AerospikeRateLimiter();
    }


    @Override
    public AerospikeRateLimiter getInstance() {
        log.info("Came to Aerospike getInstance Class");
        return lookupInstance();

    }

    @Override
    public void close() throws IOException {
        log.info("CLose Aerospike");
    }

}
