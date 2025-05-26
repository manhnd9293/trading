package com.manhnd.finance_trading.api.orders.repositories;

import com.manhnd.finance_trading.api.orders.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface OrdersRepository extends JpaRepository<OrderEntity, UUID> {
}
