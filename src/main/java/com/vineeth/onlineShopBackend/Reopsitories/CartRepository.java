package com.vineeth.onlineShopBackend.Reopsitories;

import com.vineeth.onlineShopBackend.Model.User.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,Long> {
        Optional<Cart> findByUserUserId(Long userId);
}
