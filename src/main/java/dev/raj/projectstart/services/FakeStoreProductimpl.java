package dev.raj.projectstart.services;

import dev.raj.projectstart.dtos.FakeStoreProductDto;
import dev.raj.projectstart.dtos.ProductDto;
import dev.raj.projectstart.models.Catagories;
import dev.raj.projectstart.models.Product;
import jdk.jfr.Category;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

@Service
public class FakeStoreProductimpl implements ProductService {
    private RestTemplateBuilder resttemplatebuilder;

    public FakeStoreProductimpl(RestTemplateBuilder restTemplateBuilder){
        this.resttemplatebuilder = restTemplateBuilder;
    }
    private Product converttoProduct(FakeStoreProductDto productDto)
    {
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
    public List<Product> getAllProducts() {
        RestTemplate restTemplate = resttemplatebuilder.build();
        ResponseEntity<FakeStoreProductDto[]> l =  restTemplate.getForEntity("https://fakestoreapi.com/products",
                FakeStoreProductDto[].class
                );
        List<Product> answer = new ArrayList<>();

        for(FakeStoreProductDto productDto : l.getBody()){

            Product product = converttoProduct(productDto);
            answer.add(product);
        }
        return answer;
    }

    @Override
    public Product getSingleProduct(Long productId) {

        RestTemplate restTemple = resttemplatebuilder.build();
        ResponseEntity<FakeStoreProductDto> response =  restTemple.getForEntity("https://fakestoreapi.com/products/{id}", FakeStoreProductDto.class, productId);
        FakeStoreProductDto productDto = response.getBody();
        return converttoProduct(productDto);

    }

    @Override
    public Product AddProduct(

//            String title,
//            double price,
//            String description,
//            String category,
//            String imageUrl,
            ProductDto product
    ) {
        RestTemplate restTemplate = resttemplatebuilder.build();
       ResponseEntity<ProductDto> responseEntity=   restTemplate.postForEntity("https://fakestoreapi.com/products",
                product,
                ProductDto.class);

       ProductDto productdto = responseEntity.getBody();

       Product prod = new Product();
       prod.setId(productdto.getId());
       prod.setDescription(productdto.getDescription());
       prod.setTitle(productdto.getTitle());
       prod.setPrice(productdto.getPrice());
       Catagories catagory = new Catagories();
       catagory.setName(productdto.getCatagory());
       prod.setImageUrl(productdto.getImage());


        return prod;
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
