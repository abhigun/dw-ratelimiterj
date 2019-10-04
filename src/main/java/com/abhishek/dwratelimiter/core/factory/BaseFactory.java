package com.abhishek.dwratelimiter.core.factory;

import com.abhishek.dwratelimiter.core.RateLimiterMethods;

import java.io.Closeable;

public interface BaseFactory extends Closeable {
//    To get the Rate Throttler Instance of the kind
    RateLimiterMethods getInstance();

}
