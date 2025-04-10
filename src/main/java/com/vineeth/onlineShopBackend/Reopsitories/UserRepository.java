package com.vineeth.onlineShopBackend.Reopsitories;

import com.vineeth.onlineShopBackend.Model.User.User;
import com.vineeth.onlineShopBackend.Model.venderModels.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);
}
