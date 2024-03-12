package dev.raj.projectstart.services;

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
    @Override
    public List<Product> getAllProducts() {
        RestTemplate restTemplate = resttemplatebuilder.build();
        ResponseEntity<List> l =  restTemplate.getForEntity("https://fakestoreapi.com/products",
                List.class
                );

        List<Product> answer = new ArrayList<>();

        for(Object object: l.getBody()){
            HashMap<String,Object>  hm = (HashMap<String, Object>) object;

            Product product = new Product();
            product.setId((Long)hm.get("Id"));
            product.setTitle((String)hm.get("title"));
            product.setDescription((String) hm.get("description"));
            Catagories catagories = new Catagories();
            catagories.setName((String)hm.get("category"));
            product.setImageUrl((String)hm.get("image"));
            answer.add(product);
        }

        return answer;
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
