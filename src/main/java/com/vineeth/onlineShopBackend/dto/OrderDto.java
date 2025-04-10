package com.vineeth.onlineShopBackend.dto;

import com.vineeth.onlineShopBackend.Model.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDto {
        private Long orderId;
        private String userName;
        private LocalDateTime orderDate;
        private OrderStatus status;
        private List<OrderItemDto> items;
}
