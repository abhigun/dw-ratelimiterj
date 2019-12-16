package com.abhishek.dwratelimiter.annotations.filter;

import com.abhishek.dwratelimiter.annotations.Throttled;
import com.abhishek.dwratelimiter.annotations.helpers.ThrottleRule;
import com.abhishek.dwratelimiter.core.Rule;
import com.abhishek.dwratelimiter.core.factory.FactoryManager;
import com.abhishek.dwratelimiter.utils.StorageType;
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
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

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

    private RateLimiterMethods getRateLimiter(Set<Rule> rules){
        return (RateLimiterMethods) factoryManager.getFactoryInstance(StorageType.AEROSPIKE).getInstance(rules);
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
