package org.natete.bankaccount.domain;

import java.util.Optional;

public interface AccountRepository {

    Optional<Account> findAccountByClientId(String clientId);

}
