package com.abhishek.dwratelimiter.utils;

public class RateLimiterUtils {

    private static final long INIT_TIME = 1578915202;

    /*
    Returns the Time counter of the application server from the above initiated time
    Added to avoid the Bin name limitation of 15 characters in Aerospike
    TODO: Should never change the INIT_TIME and try to Move it to System Properties to avoid changing it in the Utils Class
    * */
    public static long getTimeCounter(){
        return Math.subtractExact((System.currentTimeMillis()/1000),INIT_TIME);
    }
}
