package com.vineeth.onlineShopBackend.Reopsitories;

import com.vineeth.onlineShopBackend.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    // Get all addresses linked to a specific user
    List<Address> findByUserUserId(Long userId);

    // Get all addresses linked to a specific vendor
    List<Address> findByVendorVendorId(Long vendorId);
}

