package com.manhnd.finance_trading.api.products.entites;

import com.manhnd.finance_trading.common.entites.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "products")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductEntity extends BaseEntity {

    @Column(name = "name", nullable = false )
    private String name;

    @Column(name = "price", nullable = false )
    private Double price;

}
