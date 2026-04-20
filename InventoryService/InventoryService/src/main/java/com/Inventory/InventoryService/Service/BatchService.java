package com.Inventory.InventoryService.Service;

import com.Inventory.InventoryService.Repository.BatchRepository;
import com.Inventory.InventoryService.entity.Batch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BatchService {
    private final BatchRepository batchRepository;
    private final InventoryHandler InventoryHandler;
    @Autowired
    public BatchService(BatchRepository batchRepository, InventoryHandler InventoryHandler) {
        this.batchRepository = batchRepository;
        this.InventoryHandler = InventoryHandler;
    }
    public List<Batch> getBatches(Long productId){
        return batchRepository.findByProductIdOrderByExpiryDateAsc(productId);
    }
    public void updateInventory(Long productId, int quantity) {
        InventoryHandler.updateInventory(productId, quantity, batchRepository);
    }
}
