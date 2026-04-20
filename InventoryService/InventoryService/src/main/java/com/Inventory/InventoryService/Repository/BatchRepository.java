package com.Inventory.InventoryService.Repository;

import com.Inventory.InventoryService.entity.Batch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BatchRepository extends JpaRepository<Batch, Long> {
    List<Batch> findByProductIdOrderByExpiryDateAsc(Long productId);


}
