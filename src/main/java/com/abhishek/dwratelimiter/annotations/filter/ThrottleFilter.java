package com.abhishek.dwratelimiter.annotations.filter;

import com.abhishek.dwratelimiter.annotations.Throttled;
import com.abhishek.dwratelimiter.annotations.ThrottleRule;
import com.abhishek.dwratelimiter.core.factory.StorageFactory;
import com.abhishek.dwratelimiter.core.limiter.visitor.impl.RateLimitingVisitorImpl;
import com.abhishek.dwratelimiter.core.config.rules.Rule;
import com.abhishek.dwratelimiter.core.config.RatelimiterConfig;
import com.abhishek.dwratelimiter.core.factory.StorageFactoryManager;
import com.abhishek.dwratelimiter.core.limiter.LimiterType;
import com.abhishek.dwratelimiter.core.limiter.LimiterTypeVisitor;
import com.abhishek.dwratelimiter.utils.Constants;
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
import java.util.HashSet;
import java.util.Set;

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

    private StorageFactory getStorageFactory(){
        return storageFactoryManager.getFactoryInstance(ratelimiterConfig.getStorageConfig().getType());
    }

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {

        final AnnotatedMethod annotatedMethod = new AnnotatedMethod(resource.getResourceMethod());
        Throttled throttled = annotatedMethod.getAnnotation(Throttled.class);
        StorageFactory storageFactory = getStorageFactory();
        Set<Rule> fixedRules = new HashSet<>();
        Set<Rule> slidingWindowRules = new HashSet<>();

        Arrays.stream(throttled.throttleRule()).forEach(throttleRule -> throttleRule.type().visit(new LimiterTypeVisitor<Void>() {
            @Override
            public Void visitSliding() {
                slidingWindowRules.add(buildRule(throttleRule));
                return null;
            }

            @Override
            public Void visitFixed() {
                if(throttleRule.duration() != throttleRule.precision())
                    throw new UnsupportedOperationException("duration and precision have to be the same for fixed window limiting");
                fixedRules.add(buildRule(throttleRule));
                return null;
            }
        }));

        String key = resource.getResourceMethod().getName();
        if(!Constants.DEFAULT_PARAM.equalsIgnoreCase(throttled.param())){
            key = "_" + throttled.paramtype().filterParam(containerRequestContext,throttled.param());
        }

        storageFactory.getInstance(fixedRules,LimiterType.FIXED).isOverLimit(key,1,new RateLimitingVisitorImpl());
        storageFactory.getInstance(slidingWindowRules,LimiterType.SLIDING).isOverLimit(key,1,new RateLimitingVisitorImpl());
        log.info(resource.toString());
    }

    private Rule buildRule(ThrottleRule throttleRule){
        return Rule.builder()
                .duration(throttleRule.duration())
                .precision(throttleRule.precision())
                .limit(throttleRule.limit())
                .build();
    }
}
