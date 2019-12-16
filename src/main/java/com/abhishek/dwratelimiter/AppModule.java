package com.abhishek.dwratelimiter;

import com.abhishek.dwratelimiter.core.factory.StorageFactory;
import com.abhishek.dwratelimiter.core.factory.StorageFactoryManager;
import com.abhishek.dwratelimiter.core.storages.aerospike.AerospikeFactory;
import com.abhishek.dwratelimiter.core.storages.redis.RedisFactory;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.name.Names;

public class AppModule extends AbstractModule {

    @Override
    protected void configure(){

        bind(StorageFactoryManager.class).in(Scopes.SINGLETON);
        bind(StorageFactory.class).annotatedWith(Names.named("AEROSPIKE")).to(AerospikeFactory.class);
        bind(StorageFactory.class).annotatedWith(Names.named("REDIS")).to(RedisFactory.class);
    }

}
