package com.vineeth.onlineShopBackend.Model.venderModels;

import com.vineeth.onlineShopBackend.Model.Address;
import com.vineeth.onlineShopBackend.Model.Order;
import com.vineeth.onlineShopBackend.Model.enums.DeliveryStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryId;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order; // each or one order is associated with one order

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address deliveryAddress; // each or one delivery belongs to an address (like one address may have many deliveries)

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;  // Enum: PENDING, SHIPPED, DELIVERED

    private LocalDateTime deliveryDate;
    private LocalDateTime estimatedDeliveryDate;
    private String trackingNumber;
    private BigDecimal deliveryFee;
}
