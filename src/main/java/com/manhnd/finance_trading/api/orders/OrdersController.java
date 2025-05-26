package com.manhnd.finance_trading.api.orders;

import com.manhnd.finance_trading.api.orders.dtos.CreateOrderDto;
import com.manhnd.finance_trading.api.orders.entities.OrderEntity;
import com.manhnd.finance_trading.api.users.entities.UserEntity;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/orders")
@AllArgsConstructor
public class OrdersController {

    private OrdersService ordersService;

    @PostMapping("/")
    public OrderEntity createOrder(@RequestBody CreateOrderDto createOrderDto, @AuthenticationPrincipal UserEntity userEntity) throws BadRequestException {
        return ordersService.createOrder(createOrderDto, userEntity);
    }

}
