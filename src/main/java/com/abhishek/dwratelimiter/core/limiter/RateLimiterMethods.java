package com.abhishek.dwratelimiter.core.limiter;

import com.abhishek.dwratelimiter.core.limiter.visitor.RateLimitingVisitor;

public interface RateLimiterMethods {
    boolean isOverLimit(String key, int weight, RateLimitingVisitor vistor);



}
