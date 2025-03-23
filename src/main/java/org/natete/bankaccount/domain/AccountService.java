package org.natete.bankaccount.domain;

import java.util.List;

public interface AccountService {

    void createOperation(Operation operation, String name);

    List<Operation> historicalOperation(String name);
}
