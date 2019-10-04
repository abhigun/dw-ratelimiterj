package com.abhishek.dwratelimiter.annotations.filter;

import com.abhishek.dwratelimiter.annotations.Throttled;
import com.abhishek.dwratelimiter.core.factory.FactoryManager;
import com.abhishek.dwratelimiter.core.factory.helpers.StorageType;
import com.abhishek.dwratelimiter.core.RateLimiterMethods;
import lombok.extern.slf4j.Slf4j;
import org.glassfish.jersey.server.model.AnnotatedMethod;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import java.io.IOException;

@Slf4j
public class ThrottleFilter implements ContainerRequestFilter {
    private final FactoryManager factoryManager;

    @Context
    private HttpServletRequest request;
    private ResourceInfo resource;
    @Context
    private SecurityContext securityContext;


    public ThrottleFilter(FactoryManager factoryManager, @Context ResourceInfo resource){
        this.factoryManager = factoryManager;
        this.resource = resource;
    }

    private RateLimiterMethods getRateLimiter(){
        return (RateLimiterMethods) factoryManager.getFactoryInstance(StorageType.AEROSPIKE).getInstance();
    }

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        final AnnotatedMethod annotatedMethod = new AnnotatedMethod(resource.getResourceMethod());
        Throttled throttled = annotatedMethod.getAnnotation(Throttled.class);
        log.info(throttled.toString());
        getRateLimiter().isOverLimit("ky",1);
        log.info(resource.toString());
    }
}
