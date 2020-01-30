package com.abhishek.dwratelimiter.core.config.storage;

import com.abhishek.dwratelimiter.core.config.StorageType;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(
        value = AerospikeConfig.class,
        name = "AEROSPIKE"
), @JsonSubTypes.Type(
        value = RedisConfig.class,
        name = "REDIS"
)})
/* Parent Config to be extended by the child configs */
public abstract class StorageConfig {
    @Getter
    private StorageType type;
}
