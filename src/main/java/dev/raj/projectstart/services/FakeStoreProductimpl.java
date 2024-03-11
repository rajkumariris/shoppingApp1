package dev.raj.projectstart.services;

import dev.raj.projectstart.dtos.ProductDto;
import org.springframework.stereotype.Service;

@Service
public class FakeStoreProductimpl implements ProductService {
    @Override
    public String getAllProducts() {
        return null;
    }

    @Override
    public String AddProduct(ProductDto productdto) {
        return null;
    }

    @Override
    public String updateProduct(Long productId) {
        return null;
    }

    @Override
    public String Delete(Long productId) {
        return null;
    }
}
