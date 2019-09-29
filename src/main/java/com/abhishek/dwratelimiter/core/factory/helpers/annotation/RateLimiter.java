package com.abhishek.dwratelimiter.core.factory.helpers.annotation;

import com.abhishek.dwratelimiter.core.factory.helpers.StorageType;

public @interface RateLimiter {
    StorageType storageType();
}
