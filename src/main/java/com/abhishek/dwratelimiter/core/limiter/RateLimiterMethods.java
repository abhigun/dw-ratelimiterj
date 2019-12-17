package com.abhishek.dwratelimiter.core.limiter;

public interface RateLimiterMethods {
    boolean isOverLimit(String key, int weight);



}
