package com.vineeth.onlineShopBackend.Service;

import com.vineeth.onlineShopBackend.Model.Order;
import com.vineeth.onlineShopBackend.Model.enums.OrderStatus;
import com.vineeth.onlineShopBackend.Model.enums.ShopStatus;
import com.vineeth.onlineShopBackend.Model.venderModels.Product;
import com.vineeth.onlineShopBackend.Model.venderModels.Vendor;
import com.vineeth.onlineShopBackend.Reopsitories.OrderRepository;
import com.vineeth.onlineShopBackend.Reopsitories.ProductRepository;
import com.vineeth.onlineShopBackend.Reopsitories.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AuthService authService;

    @Override
    public Vendor getCurrentVendor(String token) throws Exception {
        return authService.getCurrentVendor(token);
    }

    @Override
    public List<Product> getAllProducts(String token) throws Exception {
        Vendor vendor = authService.getCurrentVendor(token);
        return productRepository.findByVendorId(vendor.getVendorId());
    }

    @Override
    public Product addProduct(Product product, String token) throws Exception {
        Vendor vendor = authService.getCurrentVendor(token);
        product.setVendor(vendor);
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long productId, Product updatedProduct, String token) throws Exception {
        Vendor vendor = authService.getCurrentVendor(token);
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new Exception("Product not found"));

        if (!existingProduct.getVendor().getVendorId().equals(vendor.getVendorId())) {
            throw new Exception("Unauthorized to update the product");
        }

        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setCategory(updatedProduct.getCategory());
        existingProduct.setDescription(updatedProduct.getDescription());
        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(Long productId, String token) throws Exception {
        Vendor vendor = authService.getCurrentVendor(token);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new Exception("Product not found"));

        if (!product.getVendor().getVendorId().equals(vendor.getVendorId())) {
            throw new Exception("Unauthorized to delete product");
        }

        productRepository.delete(product);
    }

    @Override
    public List<Order> getAllOrders(String token) throws Exception {
        Vendor vendor = authService.getCurrentVendor(token);
        return orderRepository.findByVendorVendorId(vendor.getVendorId());
    }

    @Override
    public List<Order> getOrdersByStatus(OrderStatus status, String token) throws Exception {
        Vendor vendor = authService.getCurrentVendor(token);
        return orderRepository.findByVendorVendorIdAndOrderStatus(vendor.getVendorId(), status);
    }

    @Override
    public void updateShopStatus(ShopStatus status, String token) throws Exception {
        Vendor vendor = authService.getCurrentVendor(token);
        vendor.setShopStatus(status);
        vendorRepository.save(vendor);
    }

    @Override
    public Vendor updateVendorProfile(Vendor updatedVendor, String token) throws Exception {
        Vendor vendor = authService.getCurrentVendor(token);
        vendor.setName(updatedVendor.getName());
        vendor.setContactNumber(updatedVendor.getContactNumber());
        return vendorRepository.save(vendor);
    }
}
