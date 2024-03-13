package dev.raj.projectstart.services;

import dev.raj.projectstart.dtos.FakeStoreProductDto;
import dev.raj.projectstart.dtos.ProductDto;
import dev.raj.projectstart.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface ProductService {


    List<Product> getAllProducts();

    Optional<Product>  getSingleProduct(Long productId);

    public Product AddProduct(

//            String title,
//            double price,
//            String description,
//            String category,
//            String imageUrl
            ProductDto product

    );
    public Product updateProduct(Long productId, Product product);
    public String replaceProduct(Long productId, Product product);
    public String Delete(Long productId);

}