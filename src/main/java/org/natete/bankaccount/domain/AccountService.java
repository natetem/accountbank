package org.natete.bankaccount.domain;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {

    BigDecimal deposit(BigDecimal amount, String name);

    BigDecimal withdraw(BigDecimal amount, String name);

   List<Operation> historicalOperation(String name);
}
