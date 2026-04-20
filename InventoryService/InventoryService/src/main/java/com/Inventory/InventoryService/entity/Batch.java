package com.Inventory.InventoryService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "batch")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "batch_id")
    private Long batchID;
    @Column(name = "product_id")
    private Long productId;
    private String productName;
    private LocalDate expiryDate;
    private int quantity;



}
