package com.manhnd.finance_trading.api.orders;

import com.manhnd.finance_trading.api.orders.dtos.CreateOrderDto;
import com.manhnd.finance_trading.api.orders.dtos.OrderItemDto;
import com.manhnd.finance_trading.api.orders.entities.OrderEntity;
import com.manhnd.finance_trading.api.orders.entities.OrderItemEntity;
import com.manhnd.finance_trading.api.orders.repositories.OrderItemsRepository;
import com.manhnd.finance_trading.api.orders.repositories.OrdersRepository;
import com.manhnd.finance_trading.api.products.entites.ProductEntity;
import com.manhnd.finance_trading.api.products.repositories.ProductsRepository;
import com.manhnd.finance_trading.api.users.entities.UserEntity;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrdersService {
    private OrdersRepository ordersRepository;
    private OrderItemsRepository orderItemsRepository;
    private ProductsRepository productsRepository;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public OrderEntity createOrder(CreateOrderDto createOrderDto, UserEntity userEntity) throws BadRequestException {
        List<UUID> productIds = createOrderDto.getItems().stream().map(OrderItemDto::getProductId).toList();
        List<ProductEntity> products = productsRepository.findAllById(productIds);
        if (products.size() < productIds.size()) {
            throw new BadRequestException("Some product id is invalid");
        }

        Map<UUID, Double> productIdToPrice = products.stream().collect(Collectors.toMap(ProductEntity::getId, ProductEntity::getPrice));

        OrderEntity newOrder = OrderEntity.builder().userId(userEntity.getId()).build();
        OrderEntity savedOrder = this.ordersRepository.save(newOrder);
        var list = createOrderDto.getItems().stream().map(item -> OrderItemEntity.builder()
                .orderId(savedOrder.getId()).productId(item.getProductId()).quantity(item.getQuantity())
                .price(productIdToPrice.get(item.getProductId())).build()).toList();
        this.orderItemsRepository.saveAll(list);

        return this.ordersRepository.findById(savedOrder.getId()).get();
    }
}
