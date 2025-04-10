package com.vineeth.onlineShopBackend.Model.venderModels;

import com.vineeth.onlineShopBackend.Model.Order;
import com.vineeth.onlineShopBackend.Model.enums.PaymentType;
import com.vineeth.onlineShopBackend.Model.enums.ShopStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vendorId;

    private String name;
    private String contactNumber;

    // One vendor can have multiple products
    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL)
    private List<Product> products;

    // One vendor can have multiple orders
    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL)
    private List<Order> orders;

    // Represents the current status of the shop (OPEN or CLOSED)
    @Enumerated(EnumType.STRING)
    private ShopStatus shopStatus;

    // Total number of deliveries completed
    private Long deliveriesCompleted;

    // Total profit earned (e.g., sum of all completed orders' profit)
    private BigDecimal profitGained;

    // Total sales value (e.g., sum of all completed orders' amounts)
    private BigInteger totalSales;

    // Type of payment vendor accepts (PAY_ON_DELIVERY or ONLINE)
    @Enumerated(EnumType.STRING)
    private PaymentType orderPaymentType;

    // Indicates whether vendor must approve the order before it is processed
    private Boolean mustAcceptOrderBeforeProcessing;
}
