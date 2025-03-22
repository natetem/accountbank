package org.natete.bankaccount.domain;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
public class Account {
    private final String name;
    private BigDecimal balance;
    private List<Operation> operations;

    public Account(String name, BigDecimal balance) {
        this.name = name;
        this.balance = balance;
        this.operations = new ArrayList<>();
    }

    public BigDecimal executeOperation(Operation operation) {
        Optional<Operation> optionalOperation= operation.execute(balance);
        if(optionalOperation.isPresent()) {
            this.operations.add(optionalOperation.get());
            this.balance = operation.getBalance();
        }
        return this.balance;
    }

}
