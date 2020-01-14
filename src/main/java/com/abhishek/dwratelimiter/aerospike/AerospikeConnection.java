package com.abhishek.dwratelimiter.aerospike;

import com.abhishek.dwratelimiter.AppConfig;
import com.abhishek.dwratelimiter.core.config.RatelimiterConfig;
import com.abhishek.dwratelimiter.core.config.storage.AerospikeConfig;
import com.abhishek.dwratelimiter.utils.StorageType;
import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Host;
import com.aerospike.client.policy.*;
import com.google.inject.Inject;
import io.dropwizard.lifecycle.Managed;

public class AerospikeConnection implements Managed {

    private final AerospikeConfig aerospikeConfig;
    private static AerospikeClient aerospikeClient;

    @Inject
    public AerospikeConnection(AppConfig appConfig){
        aerospikeConfig = (AerospikeConfig) appConfig.getStorageConfigs().get(StorageType.AEROSPIKE);
    }

    public AerospikeConnection(RatelimiterConfig ratelimiterConfig){
        aerospikeConfig = (AerospikeConfig) ratelimiterConfig.getStorageConfig();
    }

    @Override
    public void start() throws Exception {


        Policy readPolicy = new Policy();
        readPolicy.maxRetries = aerospikeConfig.getRetries();
        readPolicy.consistencyLevel = ConsistencyLevel.CONSISTENCY_ONE;
//        readPolicy.replica = Replica.MASTER_PROLES;
        readPolicy.sleepBetweenRetries = aerospikeConfig.getSleepBetweenRetries();
        readPolicy.sendKey = true;

        WritePolicy writePolicy = new WritePolicy();
        writePolicy.recordExistsAction = RecordExistsAction.REPLACE;
        writePolicy.maxRetries = aerospikeConfig.getRetries();
        writePolicy.consistencyLevel = ConsistencyLevel.CONSISTENCY_ALL;
//        writePolicy.replica = Replica.MASTER_PROLES;
        writePolicy.sleepBetweenRetries = aerospikeConfig.getSleepBetweenRetries();
        writePolicy.commitLevel = CommitLevel.COMMIT_ALL;
        writePolicy.sendKey = true;


        ClientPolicy clientPolicy = new ClientPolicy();
        clientPolicy.maxConnsPerNode = aerospikeConfig.getMaxConnectionsPerNode();
        clientPolicy.readPolicyDefault = readPolicy;
        clientPolicy.writePolicyDefault = writePolicy;
        clientPolicy.failIfNotConnected = true;
//        clientPolicy.requestProleReplicas = true;
//        clientPolicy.threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
//        clientPolicy.tlsPolicy = new TlsPolicy();
//        clientPolicy.user = aerospikeConfig.getUser();
//        clientPolicy.password = aerospikeConfig.getPassword();

        aerospikeClient = new AerospikeClient
         (
                clientPolicy,aerospikeConfig.getHosts().stream().map
                (
                        hostandPort -> new Host
                        (
                            hostandPort.getHost(),hostandPort.getPort()
                        )
                ).toArray(
                            Host[]::new
                         )
        );

    }

    @Override
    public void stop() throws Exception {
        aerospikeClient.close();
    }

    public AerospikeClient client(){
        return aerospikeClient;
    }
}
