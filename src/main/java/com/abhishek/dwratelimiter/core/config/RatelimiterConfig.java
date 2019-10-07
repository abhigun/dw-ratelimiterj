package com.abhishek.dwratelimiter.core.config;

import com.abhishek.dwratelimiter.core.StorageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RatelimiterConfig {

    private StorageType storageType;

    private AerospikeConfig aerospikeConfig;

    private RedisConfig redisConfig;
}
