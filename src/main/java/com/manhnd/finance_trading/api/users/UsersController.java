package com.manhnd.finance_trading.api.users;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UsersController {
    private UsersService usersService;

}
