package com.abhishek.dwratelimiter.core.factory.helpers;

import com.abhishek.dwratelimiter.core.factory.BaseFactory;

public abstract class AbstractBaseFactory<T> implements BaseFactory {

    protected abstract T createInstance();

    protected abstract T lookupInstance();


}
