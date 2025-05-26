package com.manhnd.finance_trading.api.orders.entities;

import com.manhnd.finance_trading.api.users.entities.UserEntity;
import com.manhnd.finance_trading.common.entites.BaseEntity;
import com.manhnd.finance_trading.common.enums.OrderState;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderEntity extends BaseEntity {

    @Column(name = "user_id")
    private UUID userId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private UserEntity user;


    @OneToMany(targetEntity = OrderItemEntity.class, mappedBy = "order", fetch = FetchType.EAGER)
//    @JoinColumn(name = "order_id")
    private List<OrderItemEntity> orderItems;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_state")
    private OrderState orderState;
}
