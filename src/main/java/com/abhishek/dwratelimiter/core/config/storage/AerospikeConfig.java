package com.abhishek.dwratelimiter.core.config.storage;

import com.abhishek.dwratelimiter.utils.HostandPort;
import com.abhishek.dwratelimiter.utils.StorageType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(callSuper = true)
public class AerospikeConfig extends StorageConfig {

    @NotNull
    private List<HostandPort> hosts;

    private String namespace;

    private String setName;

    private String username;

    private String password;

    private int maxConnectionsPerNode;

    private int timeout;

    private int retries;

    private int sleepBetweenRetries;

    private int threadPoolSize;

    private int maxSocketIdle;

    private String applicationName;


    public AerospikeConfig(){
        super(StorageType.AEROSPIKE);
    }


}
