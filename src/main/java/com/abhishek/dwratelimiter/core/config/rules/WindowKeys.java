package com.abhishek.dwratelimiter.core.config.rules;

public class WindowKeys {
    private long buckets;
    private long bucket_id;
    private long bucket_start;
    private String counter;
    private String currentTS;

    public WindowKeys(long time, int duration , int precision){
        this.buckets = (long) Math.ceil(duration/(double)precision);
        this.bucket_id = (long) (time/precision);
        this.bucket_start = bucket_id - buckets +1;
        this.counter = "" + duration + ":" + precision +":";
        this.currentTS = counter + "ts";
    }
}
