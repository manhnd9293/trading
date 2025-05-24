package com.manhnd.finance_trading.api.auth;

import com.manhnd.finance_trading.api.auth.dtos.CreateUserDto;
import com.manhnd.finance_trading.api.users.UsersService;
import com.manhnd.finance_trading.api.users.entities.UserEntity;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
    private UsersService usersService;

    public UserEntity createUser(CreateUserDto createUserDto) throws BadRequestException {
        return usersService.createUser(createUserDto);
    }
}
