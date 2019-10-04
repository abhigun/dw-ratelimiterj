package com.abhishek.dwratelimiter.resources;

import com.abhishek.dwratelimiter.AppConfig;
import com.abhishek.dwratelimiter.annotations.Throttled;
import com.abhishek.dwratelimiter.annotations.helpers.ThrottleRule;
import com.abhishek.dwratelimiter.core.factory.FactoryManager;
import com.abhishek.dwratelimiter.core.factory.helpers.AbstractBaseFactory;
import com.abhishek.dwratelimiter.core.factory.helpers.StorageType;
import com.abhishek.dwratelimiter.core.RateLimiterMethods;
import com.abhishek.dwratelimiter.core.storages.aerospike.AerospikeFactory;
import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;

@Path("/v1/documents")
@Slf4j
public class Sample {
    private final FactoryManager factoryManager;
    private final AppConfig appConfig;
    private AbstractBaseFactory abstractBaseFactory;


    @Inject
    public Sample(FactoryManager factoryManager, AppConfig appConfig){
        this.factoryManager = factoryManager;
        this.appConfig = appConfig;
    }

    @GET
    @Throttled(param = "namespace",throttleRule = {@ThrottleRule(duration = 10,precision = 10,limit = 3),@ThrottleRule(duration = 5,precision = 5,limit = 2)})
    public String getFactory(@NotNull @QueryParam("factory") final String namespace){

       abstractBaseFactory =  (AerospikeFactory)factoryManager.getFactoryInstance(StorageType.AEROSPIKE);
       RateLimiterMethods rateLimiterMethods = (RateLimiterMethods) abstractBaseFactory.getInstance();
       rateLimiterMethods.isOverLimit("getting request",1);
//       abstractBaseFactory.lookupInstance();

       return StorageType.AEROSPIKE.name();
    }

    @Path("name")
    @GET
    public String getName(@QueryParam("name") final String name ){
        return appConfig.getRatelimiterConfig().getDataBase();
    }




}
