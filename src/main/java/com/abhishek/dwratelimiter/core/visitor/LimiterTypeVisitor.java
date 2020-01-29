package com.abhishek.dwratelimiter.core.visitor;


public interface LimiterTypeVisitor<T> {
    T visitSliding();
    T visitFixed();
}
