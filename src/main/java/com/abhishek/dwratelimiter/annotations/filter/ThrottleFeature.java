package com.abhishek.dwratelimiter.annotations.filter;

import com.abhishek.dwratelimiter.annotations.Throttled;

import com.abhishek.dwratelimiter.core.factory.FactoryManager;
import com.google.inject.Inject;
import org.glassfish.jersey.server.model.AnnotatedMethod;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

@Provider
public class ThrottleFeature implements DynamicFeature {
    private final FactoryManager factoryManager;
    @Inject
    public ThrottleFeature(FactoryManager factoryManager){
        this.factoryManager = factoryManager;
    }
    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext featureContext) {
        final AnnotatedMethod annotatedMethod = new AnnotatedMethod(resourceInfo.getResourceMethod());
        Throttled throttled = annotatedMethod.getAnnotation(Throttled.class);

        if(throttled != null){
            featureContext.register(new ThrottleFilter(factoryManager,resourceInfo));
        }

    }
}
