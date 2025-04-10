package com.vineeth.onlineShopBackend.Reopsitories;

import com.vineeth.onlineShopBackend.Model.venderModels.Delivery;
import com.vineeth.onlineShopBackend.Model.enums.DeliveryStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    // Find deliveries by user ID (indirect via order)
    List<Delivery> findByOrderUserUserId(Long userId);

    // Find deliveries by vendor ID (indirect via order)
    List<Delivery> findByOrderVendorVendorId(Long vendorId);

    // Optional: by delivery status
    List<Delivery> findByOrderVendorVendorIdAndDeliveryStatus(Long vendorId, String status);

    List<Delivery> findByOrderUserUserIdAndDeliveryStatus(Long userId, String status);

}

