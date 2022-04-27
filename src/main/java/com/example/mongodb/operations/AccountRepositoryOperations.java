package com.example.mongodb.operations;

import com.example.mongodb.model.Account;
import com.example.mongodb.repository.AccountCrudRepository;
import com.example.mongodb.repository.AccountReactiveRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountRepositoryOperations {
    
    private final AccountCrudRepository accountCrudRepository;
    private final AccountReactiveRepository accountReactiveRepository;

    public AccountRepositoryOperations(final AccountCrudRepository accountCrudRepository,
                                       final AccountReactiveRepository accountReactiveRepository ) {
        this.accountCrudRepository = accountCrudRepository;
        this.accountReactiveRepository = accountReactiveRepository;
    }

    public Flux<Account> getAccounts() {
        return accountReactiveRepository
                .findAll(Example.of(new Account(null, "owner", null)));
    }

    public Mono<Account> createAccount() {
        Mono<Account> accountMono
                = accountReactiveRepository.save(new Account(null, "owner", 12.3));
        return accountMono;
    }
}
