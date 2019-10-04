package com.abhishek.dwratelimiter.core;

public interface RateLimiterMethods {
    boolean isOverLimit(String key, int weight);



}
