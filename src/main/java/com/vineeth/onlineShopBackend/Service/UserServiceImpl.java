package com.vineeth.onlineShopBackend.Service;

import com.vineeth.onlineShopBackend.Model.Address;
import com.vineeth.onlineShopBackend.Model.Order;
import com.vineeth.onlineShopBackend.Model.User.Cart;
import com.vineeth.onlineShopBackend.Model.User.CartItem;
import com.vineeth.onlineShopBackend.Model.User.User;
import com.vineeth.onlineShopBackend.Model.enums.OrderStatus;
import com.vineeth.onlineShopBackend.Model.venderModels.Product;
import com.vineeth.onlineShopBackend.Reopsitories.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthService authService;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public User getCurrentUser(String token) throws Exception {
        return authService.getCurrentUser(token);
    }

    @Override
    public User updateUserProfile(User updatedUser, String token) throws Exception {
        User user = authService.getCurrentUser(token);
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        return userRepository.save(user);
    }

    @Override
    public Cart getCart(String token) throws Exception {
        User user = authService.getCurrentUser(token);
        return cartRepository.findByUserUserId(user.getUserId()).orElseThrow(()-> new Exception("Cart not found"));
    }

    @Override
    public Cart addToCart(Long productId, String token) throws Exception {
        User user = authService.getCurrentUser(token);
        Product product = productRepository.findById(productId).orElseThrow(()-> new Exception("Product not found"));
        Cart cart = cartRepository.findByUserUserId(user.getUserId())
                .orElseGet(()-> {
                    Cart newCart = new Cart();
                    newCart.setUser(user);
                    newCart.setCartItems(new ArrayList<>());
                    return newCart;
                });

        Optional<CartItem> existingCartItem = cart.getCartItems().stream().
                filter(item-> item.getProduct().getProductId().equals(productId))
                .findFirst();
        if(existingCartItem.isPresent()){
            CartItem cartItem = existingCartItem.get();
            cartItem.setQuantity(cartItem.getQuantity()+1);
        }else{
            CartItem cartItem = new CartItem();
            cartItem.setCart(cart);
            cartItem.setProduct(product);
            cartItem.setQuantity(1);
            cart.getCartItems().add(cartItem);
        }

        return cartRepository.save(cart);
    }

    @Override
    public Cart reomveFromCart(Long productId, String token) throws Exception {
        return null;
    }

    @Override
    public Cart updateCartItemQuantity(Long productId, int quantity, String token) throws Exception {
        return null;
    }

    @Override
    public void addToLikedProduct(Long productId, String token) throws Exception {

    }

    @Override
    public void removeLikedProduct(Long productId, String token) throws Exception {

    }

    @Override
    public List<Product> getAllLikedProducts(String token) throws Exception {
        return List.of();
    }

    @Override
    public Order placeOrder(String token, Long addressId, String paymentType) throws Exception {
        return null;
    }

    @Override
    public List<Order> getUserOrders(String token) throws Exception {
        return List.of();
    }

    @Override
    public List<Order> getUserOrdersByStatus(OrderStatus status, String token) throws Exception {
        return List.of();
    }

    @Override
    public Address addAddress(Address address, String token) throws Exception {
        return null;
    }

    @Override
    public Address updateAddress(Long addressId, Address address, String token) throws Exception {
        return null;
    }

    @Override
    public void deleteAddress(Long addressId, String token) throws Exception {

    }

    @Override
    public List<Address> getUserAddresses(String token) throws Exception {
        return List.of();
    }
}
