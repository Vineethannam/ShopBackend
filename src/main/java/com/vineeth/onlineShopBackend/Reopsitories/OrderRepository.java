package com.vineeth.onlineShopBackend.Reopsitories;

import com.vineeth.onlineShopBackend.Model.Order;
import com.vineeth.onlineShopBackend.Model.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findByVendorVendorId(Long vendorId);
    List<Order> findByVendorVendorIdAndOrderStatus(Long vendorId, OrderStatus status);
    List<Order> findByUserUserId(Long userId);
    List<Order> findByUserUserIdAndOrderStatus(Long userId, OrderStatus status);
}
