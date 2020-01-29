package com.abhishek.dwratelimiter.core.visitor;

import com.abhishek.dwratelimiter.annotations.helpers.ThrottleRule;


public interface LimiterTypeVisitor<T> {
    T getSlidingWindowLimiter();
    T getFixedWindowLimiter();
}
