package com.abhishek.dwratelimiter.core.storages.redis;

import com.abhishek.dwratelimiter.core.Rule;
import com.abhishek.dwratelimiter.core.factory.helpers.AbstractBaseFactory;
import com.abhishek.dwratelimiter.utils.StorageType;
import com.abhishek.dwratelimiter.core.factory.helpers.annotation.RateLimiter;
import com.abhishek.dwratelimiter.core.storages.redis.limiter.RedisRateLimiter;
import com.google.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Set;

@Singleton
@Slf4j
@RateLimiter(storageType = StorageType.REDIS)
public class RedisFactory extends AbstractBaseFactory<RedisRateLimiter> {
    public RedisFactory(){
        log.info("Reached RedisFactory Class");
    }
    @Override
    protected RedisRateLimiter createInstance(Set<Rule> rules) {
        log.info("Redis Create Instance");
        return null;
    }
    @Override
    public RedisRateLimiter getInstance(Set<Rule> rules) {
        log.info("Redis Get");
        return null;
    }

    @Override
    public void close() throws IOException {
        log.info("Redis close");
    }
}
