package com.abhishek.dwratelimiter.core.config.rules;

import lombok.Getter;

@Getter
public class Window {
    private final long buckets;
    private final long bucket_id;
    private final long bucket_start;
    private final String counter;
    private final String currentTS;

    public Window(long time, int duration , int precision){
        this.buckets = (long) Math.ceil(duration/(double)precision);
        this.bucket_id = (long) (time/precision);
        this.bucket_start = bucket_id - buckets +1;
        this.counter = "" + duration + ":" + precision +":";
        this.currentTS = counter + "ts";
    }
}
