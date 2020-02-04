package com.abhishek.dwratelimiter.core.limiter.visitor.impl;

import com.abhishek.dwratelimiter.core.aerospike.AerospikeCommands;
import com.abhishek.dwratelimiter.core.config.rules.Rule;
import com.abhishek.dwratelimiter.core.config.rules.Window;
import com.abhishek.dwratelimiter.core.limiter.aerospike.AerospikeFixedWindowRateLimiter;
import com.abhishek.dwratelimiter.core.limiter.aerospike.AerospikeSlidingWindowRateLimiter;
import com.abhishek.dwratelimiter.core.limiter.redis.RedisFixedWindowRateLimiter;
import com.abhishek.dwratelimiter.core.limiter.redis.RedisSlidingWindowRateLimiter;
import com.abhishek.dwratelimiter.core.limiter.visitor.RateLimitingVisitor;
import com.abhishek.dwratelimiter.utils.RateLimiterUtils;
import com.aerospike.client.Record;
import com.google.common.base.Preconditions;

import java.util.HashSet;
import java.util.Set;

public class RateLimitingVisitorImpl implements RateLimitingVisitor {

    @Override
    public boolean visit(AerospikeSlidingWindowRateLimiter aerospikeSlidingWindowRateLimiter, String key) {
        final long now = RateLimiterUtils.getTimeCounter();
        final Set<Rule> rules = aerospikeSlidingWindowRateLimiter.getRules();
        final AerospikeCommands aerospikeCommands = aerospikeSlidingWindowRateLimiter.getAerospikeCommands();

        Preconditions.checkArgument(aerospikeCommands.isConnected(),"Aerospike connection is not Up");

        // Get the maximum duration of the list of rules for the ttl of the batch
        final int maxDuration = rules.stream().map(Rule::getDuration).reduce(Integer::max).orElse(0);

        Record record = aerospikeCommands.getRecord(key);
        Set<Window> windowSet = new HashSet<>(rules.size());
        for (Rule rule:rules) {
            Window window = new Window(now,rule.getDuration(),rule.getPrecision());
            windowSet.add(window);

            long prevTimestamp  = 0;
            if(!RateLimiterUtils.isNull(record))
                prevTimestamp = record.getLong(window.getCurrentTS());

            if(prevTimestamp != 0)
                prevTimestamp = window.getBucket_start();

            if(prevTimestamp > now)
                return true;








        }
        return false;
    }

    @Override
    public boolean visit(AerospikeFixedWindowRateLimiter aerospikeFixedWindowRateLimiter, String key) {
        return false;
    }

    @Override
    public boolean visit(RedisSlidingWindowRateLimiter redisSlidingWindowRateLimiter, String key) {
        return false;
    }

    @Override
    public boolean visit(RedisFixedWindowRateLimiter redisFixedWindowRateLimiter, String key) {
        return false;
    }
}
