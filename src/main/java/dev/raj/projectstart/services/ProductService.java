package dev.raj.projectstart.services;

import dev.raj.projectstart.dtos.FakeStoreProductDto;
import dev.raj.projectstart.dtos.ProductDto;
import dev.raj.projectstart.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProductService {


    List<Product> getAllProducts();

    Product  getSingleProduct(Long productId);

    public Product AddProduct(

//            String title,
//            double price,
//            String description,
//            String category,
//            String imageUrl
            ProductDto product

    );
    public String updateProduct(Long productId, Product product);

    public String Delete(Long productId);

}