package com.abhishek.dwratelimiter.utils;

import com.abhishek.dwratelimiter.AppConfig;
import com.google.common.base.Preconditions;

public class RateLimiterUtils {

    private static long INIT_TIME;

    public static void initialize(AppConfig appConfig){
        INIT_TIME = Long.getLong(appConfig.getAppTimeReference())/1000;
    }

    /*
    Returns the Time counter of the application server from the above initiated time
    Added to avoid the Bin name limitation of 15 characters in Aerospike
    * */
    public static long getTimeCounter(){
        Preconditions.checkNotNull(INIT_TIME,"Please Call RatelimiterUtils.initialize() to set the referal time");
        return Math.subtractExact((System.currentTimeMillis()/1000),INIT_TIME);
    }

    public static boolean isNull(Object o){
        return (o==null);
    }
}
