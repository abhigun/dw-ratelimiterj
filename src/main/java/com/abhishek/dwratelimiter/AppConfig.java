package com.abhishek.dwratelimiter;


import com.abhishek.dwratelimiter.core.config.storage.StorageConfig;
import com.abhishek.dwratelimiter.core.config.StorageType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.dropwizard.Configuration;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppConfig extends Configuration {

    @NotNull
    @Valid
    private Map<StorageType, StorageConfig> storageConfigs;

    @NotNull
    private StorageType storageEnv;

}
