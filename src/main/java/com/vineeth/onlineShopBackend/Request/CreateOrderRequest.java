package com.vineeth.onlineShopBackend.Request;

import com.vineeth.onlineShopBackend.Model.enums.PaymentType;

import java.util.List;

public class CreateOrderRequest {
    private Long vendorId;
    private List<OrderProductRequest> items;
    private Long addressId;
    private PaymentType paymentType;
}
