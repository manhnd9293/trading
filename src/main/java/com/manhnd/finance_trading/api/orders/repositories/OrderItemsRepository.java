package com.manhnd.finance_trading.api.orders.repositories;

import com.manhnd.finance_trading.api.orders.entities.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderItemsRepository extends JpaRepository<OrderItemEntity, UUID> {
}
