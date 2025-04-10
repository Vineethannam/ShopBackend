package com.vineeth.onlineShopBackend.Reopsitories;

import com.vineeth.onlineShopBackend.Model.User.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
        List<CartItem> findByCartCartId(Long cartId);
}
