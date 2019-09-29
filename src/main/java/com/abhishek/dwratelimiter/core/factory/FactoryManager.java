package com.abhishek.dwratelimiter.core.factory;

import com.abhishek.dwratelimiter.core.factory.helpers.AbstractBaseFactory;
import com.abhishek.dwratelimiter.core.factory.helpers.StorageType;
import com.abhishek.dwratelimiter.core.factory.helpers.annotation.RateLimiter;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Injector;
import io.dropwizard.lifecycle.Managed;
import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

public class FactoryManager  {
    private static final String HANDLER_PACKAGE = "com.abhishek.dwratelimiter.storages";
    private Map<String, AbstractBaseFactory> factoryInstances = Maps.newHashMap();

    @Inject
    public FactoryManager(Injector injector){
        Reflections reflections = new Reflections(HANDLER_PACKAGE);
        Set<Class<?>> annotatedInstances = reflections.getTypesAnnotatedWith(RateLimiter.class);

        annotatedInstances.forEach(annotatedInstance ->{
            if(AbstractBaseFactory.class.isAssignableFrom(annotatedInstance)){
                RateLimiter annotation = annotatedInstance.getAnnotation(RateLimiter.class);
                final AbstractBaseFactory factoryinstance = AbstractBaseFactory.class.cast(injector.getInstance(annotatedInstance));
                factoryInstances.put(annotation.storageType().name(),factoryinstance);
            }
        });
    }

    public AbstractBaseFactory getFactoryInstance(StorageType storageType){
//        Check for Exceptions in the factory Instances
//        TODO: isNULLorEmpty for FactoryInstances
        return factoryInstances.get(storageType.name());
    }
}
