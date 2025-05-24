package com.manhnd.finance_trading.api.users;

import com.manhnd.finance_trading.api.auth.dtos.CreateUserDto;
import com.manhnd.finance_trading.api.users.entities.UserEntity;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsersService {
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    public UserEntity createUser(CreateUserDto createUserDto) throws BadRequestException {
        String username = createUserDto.getUsername();
        Optional<UserEntity> checkUser = this.findOneByUsername(username);
        if (checkUser.isPresent()) {
            throw new BadRequestException("Username exists");
        }

        UserEntity userEntity = UserEntity.builder().username(username)
                .password(passwordEncoder.encode(createUserDto.getPassword())).build();
        return userRepository.save(userEntity);
    }

    public Optional<UserEntity> findOneByUsername(String username) {
        return this.userRepository.findOneByUsername(username);
    }
}
