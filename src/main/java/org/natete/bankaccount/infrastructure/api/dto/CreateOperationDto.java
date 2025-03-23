package org.natete.bankaccount.infrastructure.api.dto;

import java.math.BigDecimal;

public record CreateOperationDto(BigDecimal amount, String date, String type) {
}
