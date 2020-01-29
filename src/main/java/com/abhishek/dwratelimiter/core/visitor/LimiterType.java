package com.abhishek.dwratelimiter.core.visitor;


import com.abhishek.dwratelimiter.annotations.helpers.ThrottleRule;
import com.abhishek.dwratelimiter.core.rules.Rule;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum LimiterType {

    SLIDING {
        @Override
        public Set<Rule> convertRule(ThrottleRule[] throttleRules) {
            return Arrays.stream(throttleRules).map(this::buildRule).collect(Collectors.toSet());
        }

        public <T> T getRateLimiter(LimiterTypeVisitor<T> visitor){
            return visitor.getSlidingWindowLimiter();
        }
    },

    FIXED {
        @Override
        public Set<Rule> convertRule(ThrottleRule[] throttleRules) {
            return Arrays.stream(throttleRules).filter(throttleRule -> {
                if(throttleRule.duration() == throttleRule.precision())
                    return true;
                else{
                    throw new UnsupportedOperationException("Fixed Window should be having same values for duration and precision");
                }
            }).map(this::buildRule).collect(Collectors.toSet());
        }

        public <T> T getRateLimiter(LimiterTypeVisitor<T> visitor){ return visitor.getFixedWindowLimiter(); }
    };

    public Rule buildRule(ThrottleRule throttleRule){
        return Rule.builder()
                .duration(throttleRule.duration())
                .precision(throttleRule.precision())
                .limit(throttleRule.limit())
                .build();
    }

    public abstract Set<Rule> convertRule(ThrottleRule[] throttleRules);
    public abstract <T> T getRateLimiter(LimiterTypeVisitor<T> visitor);

}