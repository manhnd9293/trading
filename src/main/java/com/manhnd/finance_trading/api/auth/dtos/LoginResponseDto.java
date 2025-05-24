package com.manhnd.finance_trading.api.auth.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class LoginResponseDto {
    private UUID id;
    private String username;
    private String atk;
}
