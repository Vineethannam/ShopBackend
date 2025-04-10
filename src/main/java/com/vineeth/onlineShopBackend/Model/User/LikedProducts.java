package com.vineeth.onlineShopBackend.Model.User;

import com.vineeth.onlineShopBackend.Model.venderModels.Product;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class LikedProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likedProductId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}

