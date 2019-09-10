package com.lnold.serverchan;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties(ServerchanProperties.class)
@ConditionalOnClass(ServerchanService.class)
@ConditionalOnProperty(prefix = "spring.serverchan", value = "sckey")
public class ServerchanAutoConfiguration {

    @Autowired
    private ServerchanProperties properties;

    @Bean
    @ConditionalOnMissingBean(ServerchanService.class)
    public ServerchanService serverChanService() {
        return new ServerchanService(properties);
    }


}
