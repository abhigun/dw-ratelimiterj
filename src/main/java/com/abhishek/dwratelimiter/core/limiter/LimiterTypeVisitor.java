package com.abhishek.dwratelimiter.core.limiter;


public interface LimiterTypeVisitor<T> {
    T visitSliding();
    T visitFixed();
}
