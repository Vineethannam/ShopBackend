package com.vineeth.onlineShopBackend.Model.venderModels;

import com.vineeth.onlineShopBackend.Model.User.CartItem;
import com.vineeth.onlineShopBackend.Model.OrderItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long productId;
    private String name;
    private BigDecimal price;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category; //many products can belongs to one category || each product belongs to a category

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor; // many products belongs to one vendor || each product belongs to a vendor

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<CartItem> cartItems; // one product can be in many cartItems

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<OrderItem> orderItems; // one product can be in many || multiple order items
}
