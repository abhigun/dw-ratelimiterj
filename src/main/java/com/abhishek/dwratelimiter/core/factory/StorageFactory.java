package com.abhishek.dwratelimiter.core.factory;

import com.abhishek.dwratelimiter.core.RateLimiterMethods;
import com.abhishek.dwratelimiter.core.Rule;

import java.io.Closeable;
import java.util.Set;

public interface StorageFactory extends Closeable {
    RateLimiterMethods getInstance(Set<Rule> rules);
}
