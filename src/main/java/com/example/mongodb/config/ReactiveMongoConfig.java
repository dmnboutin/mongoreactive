package com.example.mongodb.config;

import com.mongodb.reactivestreams.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

//@Configuration
public class ReactiveMongoConfig {

    private final String databaseName;

    @Autowired
    MongoClient mongoClient;

    public ReactiveMongoConfig(@Value("${mongo.database.name}") final String databaseName) {
        this.databaseName = databaseName;
    }

    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() {
        return new ReactiveMongoTemplate(mongoClient, databaseName);
    }
}
