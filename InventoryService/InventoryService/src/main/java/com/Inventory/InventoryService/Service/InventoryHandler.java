package com.Inventory.InventoryService.Service;

import com.Inventory.InventoryService.Repository.BatchRepository;


public interface InventoryHandler {
    public void updateInventory(Long productId, int quantity, BatchRepository repository );
}
