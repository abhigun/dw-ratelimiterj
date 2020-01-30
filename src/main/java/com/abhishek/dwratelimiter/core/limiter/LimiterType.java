package com.abhishek.dwratelimiter.core.limiter;

public enum LimiterType {

    SLIDING {
        public <T> T visit(LimiterTypeVisitor<T> visitor) {
            return visitor.visitSliding();
        }
    },

    FIXED {
        public <T> T visit(LimiterTypeVisitor<T> visitor) {
            return visitor.visitFixed();
        }
    };
    public abstract <T> T visit(LimiterTypeVisitor<T> visitor);

}