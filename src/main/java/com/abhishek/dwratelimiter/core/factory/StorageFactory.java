package com.abhishek.dwratelimiter.core.factory;

import com.abhishek.dwratelimiter.core.limiter.RateLimiterMethods;
import com.abhishek.dwratelimiter.core.rules.Rule;

import java.io.Closeable;
import java.util.Set;

public interface StorageFactory extends Closeable {
    RateLimiterMethods getInstance(Set<Rule> rules);
}
