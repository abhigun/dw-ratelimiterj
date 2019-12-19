package com.abhishek.dwratelimiter.core.visitor.impl;

import com.abhishek.dwratelimiter.core.rules.Rule;
import com.abhishek.dwratelimiter.core.visitor.LimiterTypeVisitor;

public class RuleVisitorImpl implements LimiterTypeVisitor<Rule> {
    @Override
    public Rule convertToSlidingWindowRule() {
        return null;
    }

    @Override
    public Rule convertToFixedWindowRule() {
        return null;
    }

    @Override
    public Rule getSlidingWindowLimiter() {
        return null;
    }

    @Override
    public Rule getFixedWindowLimiter() {
        return null;
    }
}
