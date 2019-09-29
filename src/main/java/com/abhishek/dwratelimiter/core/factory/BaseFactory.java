package com.abhishek.dwratelimiter.core.factory;

import java.io.Closeable;

public interface BaseFactory extends Closeable {
//    To get the Rate Throttler Instance of the kind
    void getInstance();

}
