package dev.raj.projectstart.services;

import dev.raj.projectstart.dtos.ProductDto;
import org.springframework.web.bind.annotation.*;

public interface ProductService {


    public String getAllProducts();

    public String AddProduct(ProductDto productdto);

    public String updateProduct(Long productId);

    public String Delete(Long productId);

}