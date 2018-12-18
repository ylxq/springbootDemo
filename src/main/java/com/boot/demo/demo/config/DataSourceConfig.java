package com.boot.demo.demo.config;

import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.pool.HikariPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Autowired
    private Environment environment;

    @Bean("h2PrimaryDataSource")
    @Primary
    public DataSource h2PrimaryDataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setUsername(environment.getProperty("spring.datasource.username"));
        hikariDataSource.setJdbcUrl(environment.getProperty("spring.datasource.url"));
        hikariDataSource.setPassword(environment.getProperty("spring.datasource.password"));
        hikariDataSource.setDriverClassName(environment.getProperty("spring.datasource.driverClassName"));
        return hikariDataSource;

    }


    @Bean("h2SecondaryDataSource")
    public DataSource h2SecondaryDataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setUsername(environment.getProperty("spring.datasource.username1"));
        hikariDataSource.setPassword(environment.getProperty("spring.datasource.password1"));
        hikariDataSource.setJdbcUrl(environment.getProperty("spring.datasource.url1"));
        hikariDataSource.setDriverClassName(environment.getProperty("spring.datasource.driverClassName1"));
        return hikariDataSource;

    }
}
