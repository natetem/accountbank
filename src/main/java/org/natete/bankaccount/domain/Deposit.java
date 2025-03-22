package org.natete.bankaccount.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class Deposit extends Operation {

    public Deposit(BigDecimal amount, LocalDateTime date) {
        super(amount, date);
    }

    @Override
    public Optional<Operation> execute(BigDecimal balance) {
        BigDecimal newBalance =  balance.add(amount);
        this.setBalance(newBalance);
        return Optional.of(this);
    }
}
