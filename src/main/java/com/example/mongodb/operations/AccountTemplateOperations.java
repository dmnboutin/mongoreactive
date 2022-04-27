package com.example.mongodb.operations;

import com.example.mongodb.model.Account;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@Service
public class AccountTemplateOperations {

    ReactiveMongoTemplate template;

    public Mono<Account> findById(String id) {
        return template.findById(id, Account.class);
    }

    public Flux<Account> findAll() {
        return template.findAll(Account.class);
    }
    public Mono<Account> save(Mono<Account> account) {
        return template.save(account);
    }
}
