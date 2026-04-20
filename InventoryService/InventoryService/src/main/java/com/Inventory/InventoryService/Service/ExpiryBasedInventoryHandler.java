package com.Inventory.InventoryService.Service;

import com.Inventory.InventoryService.Repository.BatchRepository;
import com.Inventory.InventoryService.entity.Batch;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExpiryBasedInventoryHandler implements InventoryHandler {

    @Override
    public void updateInventory(Long productId, int quantity, BatchRepository repository) {
        List<Batch> batches = repository.findByProductIdOrderByExpiryDateAsc(productId);
        int remaining = quantity;
        for (Batch b : batches) {
            if (remaining > 0) {
                int used = Math.min(b.getQuantity(), remaining);
                b.setQuantity(b.getQuantity() - used);
                remaining -= used; repository.save(b);
            }
        }
        if (remaining > 0) {
            throw new RuntimeException("Not enough stock for productId: " + productId);
        }

    }
}
