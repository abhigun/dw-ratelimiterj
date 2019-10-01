package com.abhishek.dwratelimiter;

import com.abhishek.dwratelimiter.core.factory.FactoryManager;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class AppModule extends AbstractModule {

    @Override
    protected void configure(){
        bind(FactoryManager.class).in(Scopes.SINGLETON);
    }

}
