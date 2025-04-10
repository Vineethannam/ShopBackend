package com.vineeth.onlineShopBackend.Service;

import com.vineeth.onlineShopBackend.Config.JwtProvider;
import com.vineeth.onlineShopBackend.Model.User.User;
import com.vineeth.onlineShopBackend.Model.venderModels.Vendor;
import com.vineeth.onlineShopBackend.Reopsitories.UserRepository;
import com.vineeth.onlineShopBackend.Reopsitories.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private JwtProvider jwtProvider;


    @Override
    public User getCurrentUser(String token) throws Exception {
        String email = jwtProvider.getEmailFromJwtToken(token);
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new Exception("User not found"));
    }

    @Override
    public Vendor getCurrentVendor(String token) throws Exception {
        String email = jwtProvider.getEmailFromJwtToken(token);
        return vendorRepository.findByEmail(email)
                .orElseThrow(() -> new Exception("Vendor not found"));
    }

}

