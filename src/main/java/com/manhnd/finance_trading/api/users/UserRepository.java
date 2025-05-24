package com.manhnd.finance_trading.api.users;

import com.manhnd.finance_trading.api.users.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findOneByUsername(String username);
}
