package com.og.conferencedemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfiguration {

    @Value("${DB_URL}")
    private String dbUrl;
    @Value("${DB_USER}")
    private String dbUser;
    @Value("${DB_PASSWORD}")
    private String dbPassword;

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder<?> builder = DataSourceBuilder.create();
        builder.url(dbUrl);
        builder.username(dbUser);
        builder.password(dbPassword);
        System.out.println("Custom datasource bean initialized");
        return builder.build();
    }

}
