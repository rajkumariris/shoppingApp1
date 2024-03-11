package dev.raj.projectstart.services;

import dev.raj.projectstart.dtos.ProductDto;
import dev.raj.projectstart.models.Catagories;
import dev.raj.projectstart.models.Product;
import jdk.jfr.Category;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Locale;

@Service
public class FakeStoreProductimpl implements ProductService {
    private RestTemplateBuilder resttemplatebuilder;

    public FakeStoreProductimpl(RestTemplateBuilder restTemplateBuilder){
        this.resttemplatebuilder = restTemplateBuilder;
    }
    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getSingleProduct(Long productId) {

        RestTemplate restTemple = resttemplatebuilder.build();
        ResponseEntity<ProductDto> response =  restTemple.getForEntity("https://fakestoreapi.com/products/{id}", ProductDto.class, productId);
        ProductDto productDto = response.getBody();

        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        Catagories catagory = new Catagories();
        catagory.setName(productDto.getCatagory());
        product.setCatagory(catagory);
        product.setImageUrl(productDto.getImage());


        return product;
    }

    @Override
    public String AddProduct(
            String title,
            double price,
            String description,
            String category,
            String imageUrl
    ) {
        return null;
    }

    @Override
    public String updateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public String Delete(Long productId) {
        return null;
    }
}
