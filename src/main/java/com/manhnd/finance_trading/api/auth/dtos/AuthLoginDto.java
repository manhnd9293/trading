package com.manhnd.finance_trading.api.auth.dtos;

import lombok.Data;

@Data
public class AuthLoginDto {
    private String username;

    private String password;
}
