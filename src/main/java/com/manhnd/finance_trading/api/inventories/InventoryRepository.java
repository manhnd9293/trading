package com.manhnd.finance_trading.api.inventories;

import com.manhnd.finance_trading.api.inventories.entities.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, UUID> {
    List<InventoryEntity> findInventoryEntitiesByProductIdAndOriginalInventoryId(UUID productId, UUID originalInventoryId);
    List<InventoryEntity> findFirstByProductIdAndOriginalInventoryId(
            UUID productId, UUID originalInventoryId );
}
