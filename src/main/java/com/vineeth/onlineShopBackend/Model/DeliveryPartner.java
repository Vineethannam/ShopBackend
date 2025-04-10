package com.vineeth.onlineShopBackend.Model;


import com.vineeth.onlineShopBackend.Model.enums.DeliveryPartnerStatus;
import com.vineeth.onlineShopBackend.Model.venderModels.Delivery;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class DeliveryPartner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long partnerId;

    private String name;
    private String contactNumber;

    @Enumerated(EnumType.STRING)
    private DeliveryPartnerStatus status;  // Enum: AVAILABLE, ON_DELIVERY, UNAVAILABLE

    @OneToMany(mappedBy = "deliveryPartner", cascade = CascadeType.ALL)
    private List<Delivery> assignedDeliveries;  // List of deliveries assigned to the partner
}

