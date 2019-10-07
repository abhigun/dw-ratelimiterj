package com.abhishek.dwratelimiter.core;

public class WindowKeys {
    private long buckets;
    private long bucketid;
    private long bucket_start;
    private String counter;
    private String currentTS;

    public WindowKeys(long time, int duration , int precision){
        this.buckets = (long) Math.ceil(duration/(double)precision);
        this.bucketid = (long) (time/precision);
        this.bucket_start = bucketid - buckets +1;
        this.counter = "" + duration + ":" + precision +":";
        this.currentTS = counter + "ts";
    }
}
