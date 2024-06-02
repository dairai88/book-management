package com.example.config;

import com.example.repository.BookRepository;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
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

    @SuppressWarnings("null")
    @Override
    protected String getDatabaseName() {
        return "mybookstore";
    }

    @SuppressWarnings("null")
    @Override
    protected Collection<String> getMappingBasePackages() {
        return Arrays.asList("com.example.domain");
    }

    @SuppressWarnings("null")
    @Override
    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(
                MongoClientSettings.builder()
                        .credential(MongoCredential.createCredential("dalei", "admin", "oarnud9I".toCharArray()))
                        .applyToClusterSettings(settings -> {
                            settings.hosts(Arrays.asList(
                                    new ServerAddress("perconamongo1", 27017),
                                    new ServerAddress("perconamongo2", 27017),
                                    new ServerAddress("perconamongo3", 27017)));
                        })
                        .build());

    }
}