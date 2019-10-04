package com.abhishek.dwratelimiter.core.factory.helpers;

import com.abhishek.dwratelimiter.core.factory.BaseFactory;

import java.io.IOException;

public abstract class AbstractBaseFactory<T>{

    protected abstract T createInstance();

    protected T lookupInstance(){
        return this.createInstance();
    }

    public abstract T getInstance();


    public abstract void close() throws IOException;
}
