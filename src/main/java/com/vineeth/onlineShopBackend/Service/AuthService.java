package com.vineeth.onlineShopBackend.Service;

import com.vineeth.onlineShopBackend.Model.User.User;
import com.vineeth.onlineShopBackend.Model.venderModels.Vendor;

public interface AuthService {
    User getCurrentUser(String token) throws Exception;
    Vendor getCurrentVendor(String token) throws Exception;
}
