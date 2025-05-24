package com.manhnd.finance_trading.api.auth;

import com.manhnd.finance_trading.api.auth.dtos.AuthLoginDto;
import com.manhnd.finance_trading.api.auth.dtos.LoginResponseDto;
import com.manhnd.finance_trading.api.auth.dtos.CreateUserDto;
import com.manhnd.finance_trading.api.users.entities.UserEntity;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private AuthService authService;

    @PostMapping("/register")
    public UserEntity registerUser(@RequestBody CreateUserDto createUserDto) throws BadRequestException {
        return this.authService.createUser(createUserDto);
    }

    @PostMapping("/login")
    public LoginResponseDto loginUser(@RequestBody AuthLoginDto data) throws BadRequestException {
        return this.authService.login(data);
    }
}
