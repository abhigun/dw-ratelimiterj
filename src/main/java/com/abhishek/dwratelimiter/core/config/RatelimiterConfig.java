package com.abhishek.dwratelimiter.core.config;

import com.abhishek.dwratelimiter.core.config.storage.StorageConfig;
import com.google.inject.Singleton;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Singleton
public class RatelimiterConfig {
    @Getter
    private StorageConfig storageConfig;

}
