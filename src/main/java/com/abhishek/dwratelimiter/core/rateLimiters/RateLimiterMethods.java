package com.abhishek.dwratelimiter.core.rateLimiters;

public interface RateLimiterMethods {
    boolean isOverLimit(String key, int weight);



}
