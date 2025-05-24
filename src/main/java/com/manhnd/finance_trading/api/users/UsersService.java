package com.manhnd.finance_trading.api.users;

import com.manhnd.finance_trading.api.auth.dtos.CreateUserDto;
import com.manhnd.finance_trading.api.users.entities.UserEntity;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsersService {
    private UserRepository userRepository;

    public UserEntity createUser(CreateUserDto createUserDto) throws BadRequestException {
        String username = createUserDto.getUsername();
        UserEntity checkUser = userRepository.findOneByUsername(username);
        if (checkUser != null) {
            throw new BadRequestException("Username exists");
        }
        var userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(createUserDto.getPassword());
        return userRepository.save(userEntity);
    }
}
