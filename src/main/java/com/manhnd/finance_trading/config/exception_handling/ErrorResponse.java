package com.manhnd.finance_trading.config.exception_handling;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private String message;
}
