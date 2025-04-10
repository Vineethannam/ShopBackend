package com.vineeth.onlineShopBackend.Model;

import com.vineeth.onlineShopBackend.Model.venderModels.Product;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;  // Each item belongs to an order

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;  // Each item is linked to a product

    private Integer quantity;
    private BigDecimal price;
}

