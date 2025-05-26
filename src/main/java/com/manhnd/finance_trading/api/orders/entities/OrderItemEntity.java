package com.manhnd.finance_trading.api.orders.entities;

import com.manhnd.finance_trading.api.products.entites.ProductEntity;
import com.manhnd.finance_trading.common.entites.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "order_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemEntity extends BaseEntity {

    @Column(name = "order_id")
    private UUID orderId;

    @Column(name = "product_id")
    private UUID productId;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false, referencedColumnName = "id")
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false, referencedColumnName = "id")
    private ProductEntity product;

    private Integer quantity;

    private Double price;
}
