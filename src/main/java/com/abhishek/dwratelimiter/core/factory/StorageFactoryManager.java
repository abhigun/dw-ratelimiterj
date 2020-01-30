package com.abhishek.dwratelimiter.core.factory;

import com.abhishek.dwratelimiter.utils.StorageType;
import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Singleton
@Slf4j
public class StorageFactoryManager {
    private Map<StorageType,StorageFactory> handlers;

    @Inject
    public StorageFactoryManager(@Named("AEROSPIKE") StorageFactory aerospikeFactory,
                                 @Named("REDIS") StorageFactory redisFactory){
        this.handlers = ImmutableMap.of(StorageType.AEROSPIKE,aerospikeFactory,StorageType.REDIS,redisFactory);

    }

    public StorageFactory getFactoryInstance(StorageType storageType){
//        Check for Exceptions in the factory Instances
//        TODO: isNULLorEmpty for FactoryInstances
        return this.handlers.get(storageType);
    }
}
