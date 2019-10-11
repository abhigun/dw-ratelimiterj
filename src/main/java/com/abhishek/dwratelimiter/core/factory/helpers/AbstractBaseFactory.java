package com.abhishek.dwratelimiter.core.factory.helpers;

import com.abhishek.dwratelimiter.core.Rule;

import java.io.IOException;
import java.util.Set;

public abstract class AbstractBaseFactory<T>{

    protected abstract T createInstance(Set<Rule> rules);

    protected T lookupInstance(Set<Rule> rules){
        return this.createInstance(rules);
    }

    public abstract T getInstance(Set<Rule> rules);


    public abstract void close() throws IOException;
}
