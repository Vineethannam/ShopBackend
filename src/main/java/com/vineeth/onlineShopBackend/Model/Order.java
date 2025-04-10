package com.vineeth.onlineShopBackend.Model;

import com.vineeth.onlineShopBackend.Model.User.User;
import com.vineeth.onlineShopBackend.Model.enums.OrderStatus;
import com.vineeth.onlineShopBackend.Model.enums.PaymentType;
import com.vineeth.onlineShopBackend.Model.venderModels.Vendor;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne //each order belongs to many users
    @JoinColumn(name = "user_id")
    private User user; // each order belongs to a user || many orders belongs to a user

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;  // PENDING, COMPLETED, SHIPPED

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderItem> orderItems; // each order contain multiple items (one order contain many items)

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;  // PAY_ON_DELIVERY, ONLINE

    private Boolean acceptedByVendor;  // TRUE if vendor accepted the order

    private BigDecimal totalAmount;  // Total order price

}
