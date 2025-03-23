package org.natete.bankaccount.application;

import org.natete.bankaccount.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void createOperation(Operation operation, String name) {
        Account account = retreiveAccount(name);
        account.executeOperation(operation);
    }

    @Override
    public List<Operation> historicalOperation(String name) {
        Account account = retreiveAccount(name);
        return account.getOperations();
    }

    private Account retreiveAccount(String clientId) {
        return accountRepository.findAccountByClientId(clientId).orElseThrow(
                () -> new RuntimeException(clientId));

    }
}
