package org.natete.bankaccount.infrastructure.api;

import org.natete.bankaccount.domain.AccountService;
import org.natete.bankaccount.domain.Operation;
import org.natete.bankaccount.infrastructure.api.dto.CreateOperationDto;
import org.natete.bankaccount.infrastructure.api.mapper.OperationMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    private final OperationMapper operationMapper;

    public AccountController(AccountService accountService, OperationMapper operationMapper) {
        this.accountService = accountService;
        this.operationMapper = operationMapper;
    }

    @PostMapping("/{name}/operations")
    public ResponseEntity<Void> createOperation(@PathVariable String name,
                                               @RequestBody CreateOperationDto operationDto){
        Operation operation = operationMapper.toDomain(operationDto);
        accountService.createOperation( operation, name);
        return ResponseEntity.ok().build();
    }
}
