package com.abhishek.dwratelimiter.core.storages.aerospike;

import com.abhishek.dwratelimiter.AppConfig;
import com.abhishek.dwratelimiter.core.config.AerospikeConfig;
import com.aerospike.client.AerospikeClient;
import com.aerospike.client.policy.*;
import com.google.inject.Inject;
import io.dropwizard.lifecycle.Managed;

public class AerospikeConnection implements Managed {

    private static AerospikeConfig aerospikeConfig;
    private static AerospikeClient aerospikeClient;

    @Inject
    public AerospikeConnection(AppConfig appConfig){
        this.aerospikeConfig = appConfig.getRatelimiterConfig().getAerospikeConfig();
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
    }

    @Override
    public void stop() throws Exception {

    }
}
