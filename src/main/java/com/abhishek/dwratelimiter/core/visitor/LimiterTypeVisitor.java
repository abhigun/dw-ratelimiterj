package com.abhishek.dwratelimiter.core.visitor;

import com.abhishek.dwratelimiter.core.rules.Rule;

import java.util.Set;

public interface LimiterTypeVisitor<T> {
    T convertToSlidingWindowRule();
    T convertToFixedWindowRule();
    T getSlidingWindowLimiter();
    T getFixedWindowLimiter();
}
