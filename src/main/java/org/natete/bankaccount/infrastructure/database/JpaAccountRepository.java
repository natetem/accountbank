package org.natete.bankaccount.infrastructure.database;

import org.natete.bankaccount.domain.Account;
import org.natete.bankaccount.domain.AccountRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaAccountRepository implements AccountRepository {
    @Override
    public Optional<Account> findAccountByClientId(String clientId) {
        return Optional.empty();
    }
}
