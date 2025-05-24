package com.manhnd.finance_trading.api.auth;

import com.manhnd.finance_trading.api.auth.dtos.CreateUserDto;
import com.manhnd.finance_trading.api.users.entities.UserEntity;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthController {
    private AuthService authService;

    @PostMapping("/auth/register")
    public UserEntity registerUser(@RequestBody CreateUserDto createUserDto) throws BadRequestException {
        return this.authService.createUser(createUserDto);
    }
}
