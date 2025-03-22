package org.natete.bankaccount.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class Withdrawal extends Operation{

    public Withdrawal(BigDecimal amount, LocalDateTime date) {
        super(amount, date);
    }

    @Override
    public Optional<Operation> execute(BigDecimal balance) {
        BigDecimal newBalance = balance.subtract(amount);
        this.setBalance(newBalance);
        return Optional.of(this);
    }
}
