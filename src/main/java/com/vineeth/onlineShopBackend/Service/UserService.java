package com.vineeth.onlineShopBackend.Service;

import com.vineeth.onlineShopBackend.Model.Address;
import com.vineeth.onlineShopBackend.Model.Order;
import com.vineeth.onlineShopBackend.Model.User.Cart;
import com.vineeth.onlineShopBackend.Model.User.User;
import com.vineeth.onlineShopBackend.Model.enums.OrderStatus;
import com.vineeth.onlineShopBackend.Model.venderModels.Product;

import java.util.List;

public interface UserService {
    User getCurrentUser(String token) throws Exception;
    User updateUserProfile(User updatedUser, String token) throws Exception;

//    Cart management
    Cart getCart(String token) throws Exception;
    Cart addToCart(Long productId, String token) throws Exception;
    Cart reomveFromCart(Long productId, String token) throws Exception;
    Cart updateCartItemQuantity(Long productId, int quantity, String token) throws Exception;

//    Liked Products
    void addToLikedProduct(Long productId,String token) throws Exception;
    void removeLikedProduct(Long productId, String token) throws Exception;
    List<Product> getAllLikedProducts(String token) throws Exception;

//    Order Management
    Order placeOrder(String token, Long addressId, String paymentType) throws Exception;
    List<Order> getUserOrders(String token) throws Exception;
    List<Order> getUserOrdersByStatus(OrderStatus status, String token) throws Exception;


    // Address Handling
    Address addAddress(Address address, String token) throws Exception;
    Address updateAddress(Long addressId, Address address, String token) throws Exception;
    void deleteAddress(Long addressId, String token) throws Exception;
    List<Address> getUserAddresses(String token) throws Exception;
}
