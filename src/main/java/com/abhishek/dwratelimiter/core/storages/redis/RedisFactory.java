package com.abhishek.dwratelimiter.core.storages.redis;

import com.abhishek.dwratelimiter.core.Rule;
import com.abhishek.dwratelimiter.core.factory.StorageFactory;
import com.abhishek.dwratelimiter.core.limiter.redis.RedisRateLimiter;
import com.google.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Set;

@Singleton
@Slf4j
public class RedisFactory implements StorageFactory {
    public RedisFactory(){
        log.info("Reached RedisFactory Class");
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
