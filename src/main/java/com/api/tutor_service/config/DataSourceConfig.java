package com.api.tutor_service.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import org.springframework.jdbc.datasource.DriverManagerDataSource;


import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    
    @Value("${spring.datasource.url}")
    private String masterUrl;
    
    @Value("${spring.datasource.username}")
    private String masterUsername;
    
    @Value("${spring.datasource.password}")
    private String masterPassword;
    
    @Value("${spring.datasource.slave.url}")
    private String slaveUrl;
    
    @Value("${spring.datasource.slave.username}")
    private String slaveUsername;
    
    @Value("${spring.datasource.slave.password}")
    private String slavePassword;
    
    @Bean
    @Primary
    public DataSource masterDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(masterUrl);
        dataSource.setUsername(masterUsername);
        dataSource.setPassword(masterPassword);
        return dataSource;
    }
    
    @Bean
    public DataSource slaveDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(slaveUrl);
        dataSource.setUsername(slaveUsername);
        dataSource.setPassword(slavePassword);
        return dataSource;
    }
    

}