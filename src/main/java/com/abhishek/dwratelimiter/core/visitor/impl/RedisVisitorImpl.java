package com.abhishek.dwratelimiter.core.visitor.impl;

import com.abhishek.dwratelimiter.core.limiter.RateLimiterMethods;
import com.abhishek.dwratelimiter.core.visitor.LimiterTypeVisitor;

/**
 * @author gunda.abhishek
 * @created 14/01/2020
 * @project dw-ratelimiterj
 */
public class RedisVisitorImpl implements LimiterTypeVisitor<RateLimiterMethods> {
    @Override
    public RateLimiterMethods getSlidingWindowLimiter() {
        return null;
    }

    @Override
    public RateLimiterMethods getFixedWindowLimiter() {
        return null;
    }
}
