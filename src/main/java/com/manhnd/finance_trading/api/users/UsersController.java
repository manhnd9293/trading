package com.manhnd.finance_trading.api.users;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UsersController {
    private UsersService usersService;

    @GetMapping("/me")
    public UserDetails getMe(@AuthenticationPrincipal UserDetails userDetails) {
        return userDetails;
    }
}
