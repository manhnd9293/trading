package com.manhnd.finance_trading.api.inventories;

import com.manhnd.finance_trading.api.inventories.entities.InventoryEntity;
import com.manhnd.finance_trading.api.orders.entities.OrderEntity;
import com.manhnd.finance_trading.api.orders.entities.OrderItemEntity;
import com.manhnd.finance_trading.api.orders.repositories.OrderItemsRepository;
import com.manhnd.finance_trading.api.orders.repositories.OrdersRepository;
import com.manhnd.finance_trading.common.enums.OrderState;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class InventoryService {
    private InventoryRepository inventoryRepository;
    private OrdersRepository ordersRepository;
    private OrderItemsRepository orderItemsRepository;

    @Transactional
    public void processNewOrder(OrderEntity order) {
        if (order.getOrderState() != OrderState.CREATE) {
            return;
        }

        List<OrderItemEntity> orderItems = orderItemsRepository.findByOrderId(order.getId());
        List<Object> list = orderItems.stream().map(item -> {
            List<InventoryEntity> listInventory =
                    inventoryRepository.findInventoryEntitiesByProductIdAndOriginalInventoryId(item.getProductId(), null);
            if (listInventory.isEmpty()) {
                return Collections.EMPTY_LIST;
            }
            InventoryEntity inventoryEntity = listInventory.get(0);

            return InventoryEntity.builder()
                    .originalInventoryId(inventoryEntity.getId())
                    .quantity((double) item.getQuantity())
                    .userId(item.getOrder().getUserId())
                    .build();

        }).toList();


    }
}
