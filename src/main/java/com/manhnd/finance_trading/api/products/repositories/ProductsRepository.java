package com.manhnd.finance_trading.api.products.repositories;

import com.manhnd.finance_trading.api.products.entites.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductsRepository extends JpaRepository<ProductEntity, UUID> {
}
