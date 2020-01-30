package com.abhishek.dwratelimiter.utils;

public class RateLimiterUtils {

    public static final long INIT_TIME = 110000000;
//    private static final long INIT_TIME = (Long.getLong(System.getProperty("time"))/1000);

    /*
    Returns the Time counter of the application server from the above initiated time
    Added to avoid the Bin name limitation of 15 characters in Aerospike
    * */
    public static long getTimeCounter(){
        return Math.subtractExact((System.currentTimeMillis()/1000),INIT_TIME);
    }
}
