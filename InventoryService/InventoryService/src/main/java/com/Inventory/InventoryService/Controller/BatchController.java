package com.Inventory.InventoryService.Controller;

import com.Inventory.InventoryService.Service.BatchService;
import com.Inventory.InventoryService.entity.Batch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/inventory")
public class BatchController {
    @Autowired
    public BatchService batchService;

    @GetMapping("/{productId}")
    List<Batch> BatchList(@PathVariable Long productId){
        return batchService.getBatches(productId);

    }
    @PostMapping("/update")
    public ResponseEntity<String> updateInventory(@RequestBody Map<String, Object> request) {
        Long productId = Long.valueOf(request.get("productId").toString());
        int quantity = Integer.parseInt(request.get("quantity").toString());
        batchService.updateInventory(productId, quantity);
        return ResponseEntity.ok("Inventory updated"); }
}
