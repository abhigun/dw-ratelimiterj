package com.abhishek.dwratelimiter.core.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatelimiterConfig {

    @NotNull
    @Valid
    private String dataBase;


}
