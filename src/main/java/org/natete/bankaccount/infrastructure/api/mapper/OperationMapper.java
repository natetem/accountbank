package org.natete.bankaccount.infrastructure.api.mapper;

import org.mapstruct.Mapper;
import org.natete.bankaccount.domain.Deposit;
import org.natete.bankaccount.domain.Operation;
import org.natete.bankaccount.domain.Withdrawal;
import org.natete.bankaccount.infrastructure.api.dto.CreateOperationDto;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public abstract class OperationMapper implements GenericMapper<Operation, CreateOperationDto> {

    public Operation toDomain(CreateOperationDto operationDto){
        if(operationDto == null){
            return null;
        }
        if(operationDto.type().equals("DEPOSIT")){
            return new Deposit(operationDto.amount(), LocalDateTime.parse(operationDto.date()));
        }
        if(operationDto.type().equals("WITHDRAWAL")){
            return new Withdrawal(operationDto.amount(), LocalDateTime.parse(operationDto.date()));
        }
        return null;
    }


}


