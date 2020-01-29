package com.abhishek.dwratelimiter.annotations;

import com.abhishek.dwratelimiter.annotations.helpers.ThrottleRule;

import javax.ws.rs.NameBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation class for configuring the rules of the window
 * param is the resource parameter which can be used as a key TODO: Have an identifier of query or path to search for the param
 * if param is null it will be treated as a absolute rules for the resource
 * throttledRule[] specifies the list of rules configured for the resource
 * LimiterType identifies the type of Ratelimiting to be done on the resource Eg. SLIDING, FIXED
 * if a resource requires both sliding and fixed type of limiting, adding a second annotation could solve the issue
 */
@NameBinding
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Throttled {
    String param();
    ThrottleRule[] throttleRule();
}
