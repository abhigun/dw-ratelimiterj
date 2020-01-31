package com.abhishek.dwratelimiter;

import com.abhishek.dwratelimiter.core.config.RatelimiterConfig;
import com.abhishek.dwratelimiter.core.factory.StorageFactory;
import com.abhishek.dwratelimiter.core.factory.StorageFactoryManager;
import com.abhishek.dwratelimiter.core.factory.aerospike.AerospikeFactory;
import com.abhishek.dwratelimiter.core.factory.redis.RedisFactory;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.google.inject.Singleton;
import com.google.inject.name.Names;

public class AppModule extends AbstractModule {

    @Override
    protected void configure(){

        bind(StorageFactoryManager.class).in(Scopes.SINGLETON);
        bind(StorageFactory.class).annotatedWith(Names.named("AEROSPIKE")).to(AerospikeFactory.class);
        bind(StorageFactory.class).annotatedWith(Names.named("REDIS")).to(RedisFactory.class);
    }

    @Provides
    @Singleton
    public RatelimiterConfig getRateLimiterConfig(AppConfig appConfig){
        return RatelimiterConfig.builder().storageConfig(appConfig.getStorageConfigs().get(appConfig.getStorageEnv())).build();
    }

}
