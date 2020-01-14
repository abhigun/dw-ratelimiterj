package com.abhishek.dwratelimiter.aerospike;

import com.abhishek.dwratelimiter.AppConfig;
import com.abhishek.dwratelimiter.core.config.RatelimiterConfig;
import com.abhishek.dwratelimiter.core.config.storage.AerospikeConfig;
import com.abhishek.dwratelimiter.utils.StorageType;
import com.aerospike.client.AerospikeClient;
import com.aerospike.client.policy.ClientPolicy;
import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;

/**
 * @author gunda.abhishek
 * @created 14/01/2020
 * @project dw-ratelimiterj
 */
@Slf4j
public class AerospikeCommands {
    private final AerospikeConfig aerospikeConfig;
    private final AerospikeConnection aerospikeConnection;

    @Inject
    public AerospikeCommands(AppConfig appConfig, AerospikeConnection aerospikeConnection){
        this.aerospikeConfig = (AerospikeConfig) appConfig.getStorageConfigs().get(StorageType.AEROSPIKE);
        this.aerospikeConnection = aerospikeConnection;
    }

    public AerospikeCommands(RatelimiterConfig ratelimiterConfig, AerospikeConnection aerospikeConnection){
        this.aerospikeConfig = (AerospikeConfig) ratelimiterConfig.getStorageConfig();
        this.aerospikeConnection = aerospikeConnection;
    }

    private AerospikeClient getClient(){
        return aerospikeConnection.client();
    }

    private ClientPolicy getPolicy(){
        return aerospikeConnection.policy();
    }

    private void getKey(String key){

    }
    public void saveRecord(String key){

    }

    public void createOnly(){

    }

    public void getRecord(){

    }

    public void getBinValue(){

    }

    public void deleteRecord(){

    }

    public void deleteBin(){

    }

    public void changeExpiry(){

    }



}
