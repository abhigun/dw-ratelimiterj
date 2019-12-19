package com.abhishek.dwratelimiter.core.limiter;

import com.abhishek.dwratelimiter.core.limiter.visitor.RateLimitingVistor;

public interface RateLimiterMethods {
    boolean isOverLimit(String key, int weight, RateLimitingVistor vistor);



}
