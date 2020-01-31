package com.abhishek.dwratelimiter.utils;

public class RateLimiterUtils {

    private static String INIT_TIME;

    public static void

    /*
    Returns the Time counter of the application server from the above initiated time
    Added to avoid the Bin name limitation of 15 characters in Aerospike
    * */
    public static long getTimeCounter(){
        return Math.subtractExact((System.currentTimeMillis()/1000),(Long.getLong(System.getProperty("time"))/1000));
    }
}
