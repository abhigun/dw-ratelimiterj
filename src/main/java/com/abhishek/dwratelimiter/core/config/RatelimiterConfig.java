package com.abhishek.dwratelimiter.core.config;

import com.abhishek.dwratelimiter.core.config.storage.StorageConfig;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RatelimiterConfig {
    @Getter
    private StorageConfig storageConfig;
}
