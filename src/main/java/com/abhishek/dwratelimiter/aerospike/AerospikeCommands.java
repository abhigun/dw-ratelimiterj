package com.abhishek.dwratelimiter.aerospike;

import com.abhishek.dwratelimiter.AppConfig;
import com.abhishek.dwratelimiter.core.config.RatelimiterConfig;
import com.abhishek.dwratelimiter.core.config.storage.AerospikeConfig;
import com.abhishek.dwratelimiter.utils.StorageType;
import com.aerospike.client.*;
import com.aerospike.client.policy.ClientPolicy;
import com.aerospike.client.policy.RecordExistsAction;
import com.aerospike.client.policy.WritePolicy;
import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

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
    private boolean isKeyExists(Key k){
        return getClient().exists(getPolicy().readPolicyDefault,k);
    }
    private Key getKey(String key){
        try {
            return new Key(aerospikeConfig.getNamespace(),aerospikeConfig.getSetName(),key);
        } catch (AerospikeException e) {
            log.error("Error while creating a key");
            e.printStackTrace();
            throw new AerospikeException();
        }
    }

    private void put(Key k, RecordExistsAction recordExistsAction, int expiry, Bin... bins){
        WritePolicy writePolicy = new WritePolicy(getPolicy().writePolicyDefault);
        writePolicy.recordExistsAction = recordExistsAction;
        if(expiry > 0)
            writePolicy.expiration = expiry;

        getClient().put(writePolicy,k,bins);
    }

    private Record get(Key k){
        return getClient().get(getClient().readPolicyDefault,k);
    }

    private Boolean delete(Key k){
        return getClient().delete(getPolicy().writePolicyDefault,k);
    }
    public void saveRecord(String key, int expiry, Bin... bins){
        try {
            Key k = getKey(key);
            put(k,RecordExistsAction.REPLACE,expiry,bins);
        } catch (AerospikeException e) {
            log.error("Error while saving a record");
            e.printStackTrace();
            throw new AerospikeException();
        }

    }

    public void createOnly(String key, int expiry, Bin... bins){
        try {
            Key k = getKey(key);
            if(isKeyExists(k)){
                log.error("Key already exists with this name {}",key);
                throw new AerospikeException();
            }
            put(k,RecordExistsAction.CREATE_ONLY,expiry,bins);
        } catch (AerospikeException e) {
            e.printStackTrace();
        }
    }

    public Record getRecord(String key){
        return get(getKey(key));
    }

    public String getBin(String key, Bin bin){
        return get(getKey(key)).getString(bin.name);
    }

    public Boolean deleteRecord(String key){
        return delete(getKey(key));
    }

    public void deleteBins(String key, Set<String> binNames){
        List<Bin> bins = new ArrayList<>();
        binNames.stream().forEach(binName->{
            bins.add(new Bi)
        });
    }

    public void changeExpiry(){

    }



}
