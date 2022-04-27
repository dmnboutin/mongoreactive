package com.example.mongodb.controller;

import com.example.mongodb.model.Account;
import com.example.mongodb.operations.AccountRepositoryOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class AccountController {

    private final AccountRepositoryOperations accountRepositoryOperations;

    public AccountController(final AccountRepositoryOperations accountRepositoryOperations) {
        this.accountRepositoryOperations = accountRepositoryOperations;
    }

    @GetMapping("/account")
    private Mono<Account> createAccount() {
        return accountRepositoryOperations.createAccount();
    }

}
