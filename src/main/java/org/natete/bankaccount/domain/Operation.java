package org.natete.bankaccount.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Getter
public abstract  class Operation {
    protected final String type;
    protected final BigDecimal amount;
    @Setter
    protected BigDecimal balance;
    protected final LocalDateTime date;

    protected Operation(BigDecimal amount, LocalDateTime date) {
        this.amount = amount;
        this.date = date;
        this.type = this.getClass().getSimpleName();
    }

    public abstract Optional<Operation> execute(BigDecimal balance);

}
