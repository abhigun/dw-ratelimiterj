package com.abhishek.dwratelimiter.core.visitor;


public enum LimiterType {

    SLIDING {
        @Override
        public <T> T getRule( LimiterTypeVisitor<T> visitor ) {
            return null;
        }
        @Override
        public <T> T getRateLimiter(LimiterTypeVisitor<T> visitor){
            return visitor.getSlidingWindowLimiter();
        }
    },

    FIXED {
        @Override
        public <T> T getRule( LimiterTypeVisitor<T> visitor ) {
            return null;
        }
        @Override
        public <T> T getRateLimiter(LimiterTypeVisitor<T> visitor){
            return visitor.getFixedWindowLimiter();
        }
    };

    public abstract <T> T getRule( LimiterTypeVisitor<T> visitor );
    public abstract <T> T getRateLimiter(LimiterTypeVisitor<T> visitor);

}