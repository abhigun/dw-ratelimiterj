package com.abhishek.dwratelimiter.resources;

import com.abhishek.dwratelimiter.core.factory.FactoryManager;
import com.abhishek.dwratelimiter.core.factory.helpers.AbstractBaseFactory;
import com.abhishek.dwratelimiter.core.factory.helpers.StorageType;
import com.abhishek.dwratelimiter.core.rateLimiters.RateLimiterMethods;
import com.abhishek.dwratelimiter.core.storages.aerospike.AerospikeFactory;
import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;

@Path("/v1/documents")
@Slf4j
public class Sample {
    private final FactoryManager factoryManager;
    private AbstractBaseFactory abstractBaseFactory;

    @Inject
    public Sample(FactoryManager factoryManager){
        this.factoryManager = factoryManager;
    }

    @GET
    public String getFactory(@NotNull @QueryParam("factory") final String namespace){
       abstractBaseFactory =  (AerospikeFactory)factoryManager.getFactoryInstance(StorageType.AEROSPIKE);
       abstractBaseFactory.getInstance();
       return StorageType.AEROSPIKE.name();
    }




}
