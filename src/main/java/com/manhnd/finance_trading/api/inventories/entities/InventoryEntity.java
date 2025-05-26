package com.manhnd.finance_trading.api.inventories.entities;

import com.manhnd.finance_trading.api.products.entites.ProductEntity;
import com.manhnd.finance_trading.api.users.entities.UserEntity;
import com.manhnd.finance_trading.common.entites.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "inventories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryEntity extends BaseEntity {
    @Column(name = "product_id")
    private UUID productId;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false, referencedColumnName = "id")
    private ProductEntity product;

    @Column(name = "user_id")
    private UUID userId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private UserEntity user;

    @Column(name = "quantity")
    private Double quantity;

    @Column(name = "cost")
    private Double purchasedCost;

    @Column(name = "expired_date")
    private Date expiredDate;

    @Column(name = "original_inventory_id", nullable = true)
    private UUID originalInventoryId;

    @ManyToOne()
    @JoinColumn(name = "original_inventory_id", referencedColumnName = "id", insertable = false, updatable = false)
    private InventoryEntity originalInventory;

    @OneToMany(mappedBy = "originalInventory")
    private List<InventoryEntity> partialInventories;
}
