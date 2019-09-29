package com.abhishek.dwratelimiter.core.storages.redis;

import com.abhishek.dwratelimiter.core.factory.helpers.AbstractBaseFactory;
import com.abhishek.dwratelimiter.core.factory.helpers.StorageType;
import com.abhishek.dwratelimiter.core.factory.helpers.annotation.RateLimiter;
import com.abhishek.dwratelimiter.core.storages.redis.limiter.RedisRateLimiter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
@Slf4j
@RateLimiter(storageType = StorageType.REDIS)
public class RedisFactory extends AbstractBaseFactory<RedisRateLimiter> {
    @Override
    protected RedisRateLimiter createInstance() {
        log.info("Redis Create Instance");
        return null;
    }

    @Override
    protected RedisRateLimiter lookupInstance() {
        log.info("Redis Look up ");
        return null;
    }

    @Override
    public void getInstance() {
        log.info("Redis Get");
    }

    @Override
    public void close() throws IOException {
        log.info("Redis close");
    }
}
