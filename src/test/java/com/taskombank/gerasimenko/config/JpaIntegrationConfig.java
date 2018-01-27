package com.taskombank.gerasimenko.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.taskombank.gerasimenko")
public class JpaIntegrationConfig {
}
