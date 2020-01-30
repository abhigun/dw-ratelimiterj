package com.abhishek.dwratelimiter.core.factory;

import com.abhishek.dwratelimiter.core.limiter.RateLimiterMethods;
import com.abhishek.dwratelimiter.core.config.rules.Rule;
import com.abhishek.dwratelimiter.core.limiter.LimiterType;

import java.io.Closeable;
import java.util.Set;

public interface StorageFactory extends Closeable {
    RateLimiterMethods getInstance(Set<Rule> rules, LimiterType limiterType);

}
