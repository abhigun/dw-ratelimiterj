package com.abhishek.dwratelimiter;


import com.abhishek.dwratelimiter.core.factory.FactoryManager;
import com.abhishek.dwratelimiter.utils.SerDe;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.inject.Stage;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.lifecycle.Managed;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import lombok.extern.slf4j.Slf4j;
import ru.vyarus.dropwizard.guice.GuiceBundle;
import ru.vyarus.dropwizard.guice.module.installer.feature.ManagedInstaller;

@Slf4j
public class App extends Application<AppConfig>
{
    public static void main(String[] args) throws Exception {
        log.info(args.toString());
        new App().run(args);
    }
    @Override
    public void initialize(Bootstrap<AppConfig> bootstrap){
        super.initialize(bootstrap);
        bootstrap.addBundle(GuiceBundle.<AppConfig>builder()
                .enableAutoConfig(getClass().getPackage().getName())
                .modules(
                        new AppModule()
                )
                .installers(ManagedInstaller.class)
                .build(Stage.PRODUCTION)
        );
    }

    @Override
    public void run(AppConfig appConfig, Environment environment) throws Exception {
        log.info(String.valueOf(appConfig));
        environment.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        environment.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        environment.getObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        environment.getObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        environment.getObjectMapper().configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        environment.getObjectMapper().configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true);


        SerDe.init(environment.getObjectMapper());

    }
}
