package com.abhishek.dwratelimiter.core.config;


import com.abhishek.dwratelimiter.utils.HostandPort;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class RedisConfig {

    @NotNull
    private List<HostandPort> hosts;

    private String namespace;

    private String username;

    private String password;

    private int maxConnectionsPerNode;

    private int timeout;

    private int retries;


}
