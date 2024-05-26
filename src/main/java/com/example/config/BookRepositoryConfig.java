package com.example.config;

import com.example.repository.BookRepository;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import java.util.Arrays;
import java.util.Collection;

@Configuration
@EnableMongoRepositories(basePackageClasses = BookRepository.class)
public class BookRepositoryConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "bookstore";
    }

    @Override
    protected Collection<String> getMappingBasePackages() {
        return Arrays.asList("com.example.domain");
    }

    @Override
    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(
            MongoClientSettings.builder()
            .applyConnectionString(new ConnectionString("mongodb://192.168.64.5:27017,192.168.64.6:27017,192.168.64.7:27017"))
            .build());

    }
}