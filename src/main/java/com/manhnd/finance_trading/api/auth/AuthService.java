package com.manhnd.finance_trading.api.auth;

import com.manhnd.finance_trading.api.auth.dtos.AuthLoginDto;
import com.manhnd.finance_trading.api.auth.dtos.CreateUserDto;
import com.manhnd.finance_trading.api.auth.dtos.LoginResponseDto;
import com.manhnd.finance_trading.api.users.UsersService;
import com.manhnd.finance_trading.api.users.entities.UserEntity;
import com.manhnd.finance_trading.config.security.JwtService;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
    private UsersService usersService;
    private JwtService jwtService;
    private AuthenticationManager authenticationManager;

    public UserEntity createUser(CreateUserDto createUserDto) throws BadRequestException {
        return usersService.createUser(createUserDto);
    }

    public LoginResponseDto login(AuthLoginDto data) throws BadRequestException {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        data.getUsername(),
                        data.getPassword()
                )
        );
        UserEntity userEntity = this.usersService.findOneByUsername(data.getUsername()).get();

        String token = jwtService.generateToken(userEntity);
        return LoginResponseDto.builder().id(userEntity.getId()).atk(token).username(userEntity.getUsername()).build();
    }
}
