package com.abhishek.dwratelimiter.core.config;

import javax.ws.rs.container.ContainerRequestContext;
import java.util.Optional;

/**
 * @author gunda.abhishek
 * @created 30/01/2020
 */
public enum ParamType {
    QUERY{
        @Override
        public Optional<String> filterParam(ContainerRequestContext containerRequestContext, String param) {
            return Optional.ofNullable(containerRequestContext.getUriInfo().getQueryParameters().getFirst(param));

        }
    }, PATH{
        @Override
        public Optional<String> filterParam(ContainerRequestContext containerRequestContext, String param) {
            return Optional.ofNullable(containerRequestContext.getUriInfo().getPathParameters().getFirst(param));
        }
    };

    public abstract Optional<String> filterParam(ContainerRequestContext containerRequestContext, String param);
}
