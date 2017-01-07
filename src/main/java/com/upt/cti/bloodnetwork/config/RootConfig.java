package com.upt.cti.bloodnetwork.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.upt.cti.bloodnetwork.service.ServiceBeansMarker;

@Configuration
@ComponentScan(basePackageClasses = ServiceBeansMarker.class)
@Import(value = PersistenceConfig.class)
public class RootConfig {

}
