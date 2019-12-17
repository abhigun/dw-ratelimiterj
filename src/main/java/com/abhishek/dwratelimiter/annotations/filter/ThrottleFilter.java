package com.abhishek.dwratelimiter.annotations.filter;

import com.abhishek.dwratelimiter.annotations.Throttled;
import com.abhishek.dwratelimiter.annotations.helpers.ThrottleRule;
import com.abhishek.dwratelimiter.core.Rule;
import com.abhishek.dwratelimiter.core.config.RatelimiterConfig;
import com.abhishek.dwratelimiter.core.factory.StorageFactoryManager;
import com.abhishek.dwratelimiter.core.limiter.RateLimiterMethods;
import lombok.extern.slf4j.Slf4j;
import org.glassfish.jersey.server.model.AnnotatedMethod;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class ThrottleFilter implements ContainerRequestFilter {
    private final StorageFactoryManager storageFactoryManager;
    private final RatelimiterConfig ratelimiterConfig;
    @Context
    private HttpServletRequest request;
    private ResourceInfo resource;
    @Context
    private SecurityContext securityContext;


    public ThrottleFilter(StorageFactoryManager storageFactoryManager, RatelimiterConfig ratelimiterConfig, @Context ResourceInfo resource){
        this.storageFactoryManager = storageFactoryManager;
        this.ratelimiterConfig = ratelimiterConfig;
        this.resource = resource;
    }

    private RateLimiterMethods getRateLimiter(Set<Rule> rules){
        return storageFactoryManager.getFactoryInstance(ratelimiterConfig.getStorageConfig().getType()).getInstance(rules);
    }

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {

        final AnnotatedMethod annotatedMethod = new AnnotatedMethod(resource.getResourceMethod());
        Throttled throttled = annotatedMethod.getAnnotation(Throttled.class);
        Set<Rule> rules = Arrays.stream(throttled.throttleRule()).map(this::converttoRule).collect(Collectors.toSet());
        log.info(throttled.toString());
        String key = resource.getResourceMethod().getName() + "_"+containerRequestContext.getUriInfo().getQueryParameters().get(throttled.param()).get(0);
        getRateLimiter(rules).isOverLimit(key,1);
        log.info(resource.toString());
    }
    private Rule converttoRule(ThrottleRule throttleRule){
        return Rule.builder()
                .duration(throttleRule.duration())
                .precision(throttleRule.precision())
                .limit(throttleRule.limit())
                .build();
    }
}
