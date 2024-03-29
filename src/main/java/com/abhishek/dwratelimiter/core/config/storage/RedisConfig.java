package com.abhishek.dwratelimiter.core.config.storage;


import com.abhishek.dwratelimiter.utils.HostandPort;
import com.abhishek.dwratelimiter.core.config.StorageType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RedisConfig extends StorageConfig{

    @NotNull
    private List<HostandPort> hosts;

    private String namespace;

    private String username;

    private String password;

    private int maxConnectionsPerNode;

    private int timeout;

    private int retries;

    private String applicationName;

    public RedisConfig(){
        super(StorageType.REDIS);
    }


}
