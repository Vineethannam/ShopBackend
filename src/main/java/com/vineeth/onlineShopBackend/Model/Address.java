package com.vineeth.onlineShopBackend.Model;

import com.vineeth.onlineShopBackend.Model.User.User;
import com.vineeth.onlineShopBackend.Model.venderModels.Delivery;
import com.vineeth.onlineShopBackend.Model.venderModels.Vendor;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    private String street;
    private String city;
    private String state;
    private String country;
    private String postalCode;

    // Optional mapping to User
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Optional mapping to Vendor
    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    // Deliveries mapped to this address
    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private List<Delivery> deliveries;
}


