package com.manhnd.finance_trading.api.users;

import com.manhnd.finance_trading.api.users.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findOneByUsername(String username);
}
