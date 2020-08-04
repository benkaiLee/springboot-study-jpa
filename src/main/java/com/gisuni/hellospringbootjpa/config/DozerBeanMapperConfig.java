package com.gisuni.hellospringbootjpa.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DozerBeanMapperConfig {
    @Bean
    public DozerBeanMapper mapper(){
        return new DozerBeanMapper();
    }
}
