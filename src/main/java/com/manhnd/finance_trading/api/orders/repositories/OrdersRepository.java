package com.manhnd.finance_trading.api.orders.repositories;

import com.manhnd.finance_trading.api.orders.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrdersRepository extends JpaRepository<OrderEntity, UUID> {
}
