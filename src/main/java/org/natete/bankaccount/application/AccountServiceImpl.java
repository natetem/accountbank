package org.natete.bankaccount.application;

import org.natete.bankaccount.domain.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public BigDecimal deposit(BigDecimal amount, String name) {
        return accountRepository.findAccountByClientId(name)
                .map(account -> account.executeOperation(new Deposit(amount, LocalDateTime.now())))
                .orElse(BigDecimal.ZERO);

    }

    @Override
    public BigDecimal withdraw(BigDecimal amount, String name) {
        return accountRepository.findAccountByClientId(name)
                .map(account -> account.executeOperation(new Withdrawal(amount, LocalDateTime.now())))
                .orElse(BigDecimal.ZERO);

    }

    @Override
    public List<Operation> historicalOperation(String name) {
        return accountRepository.findAccountByClientId(name)
                .map(Account::getOperations)
                .orElse(Collections.emptyList());

    }
}
