package com.vineeth.onlineShopBackend.Reopsitories;

import com.vineeth.onlineShopBackend.Model.venderModels.Category;
import com.vineeth.onlineShopBackend.Model.venderModels.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByVendorId(Long vendorId);
    List<Product> findByCategory(Category category);
    List<Product> findByNameContainingIgnoreCase(String keyword);
}
