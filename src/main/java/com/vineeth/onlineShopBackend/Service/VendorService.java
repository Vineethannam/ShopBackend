package com.vineeth.onlineShopBackend.Service;

import com.vineeth.onlineShopBackend.Model.Order;
import com.vineeth.onlineShopBackend.Model.enums.OrderStatus;
import com.vineeth.onlineShopBackend.Model.enums.ShopStatus;
import com.vineeth.onlineShopBackend.Model.venderModels.Product;
import com.vineeth.onlineShopBackend.Model.venderModels.Vendor;

import java.util.List;

public interface VendorService {
    Vendor getCurrentVendor(String token) throws Exception;

    List<Product> getAllProducts(String token) throws Exception;

    Product addProduct(Product product, String token) throws Exception;

    Product updateProduct(Long productId, Product updatedProduct, String token) throws Exception;

    void deleteProduct(Long productId, String token) throws Exception;

    List<Order> getAllOrders(String token) throws Exception;

    List<Order> getOrdersByStatus(OrderStatus status, String token) throws Exception;

    void updateShopStatus(ShopStatus status, String token) throws Exception;

    Vendor updateVendorProfile(Vendor updatedVendor, String token) throws Exception;
}

