package dev.raj.projectstart.clients.Fakestoreapi;

import dev.raj.projectstart.dtos.ProductDto;
import dev.raj.projectstart.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Component
public class FakeStoreClient {
   private RestTemplateBuilder restTemplateBuilder;

   public  FakeStoreClient(RestTemplateBuilder restTemplateBuilder){
       this.restTemplateBuilder = restTemplateBuilder;

   }
    public List<FakeStoreProductDto> getAllProducts(){
        RestTemplate restTemplate =restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> l =  restTemplate.getForEntity("https://fakestoreapi.com/products",
                FakeStoreProductDto[].class
        );
        return Arrays.asList(l.getBody());
    }

    Optional<FakeStoreProductDto> getSingleProduct(Long productId){
        return null;
    }

    public FakeStoreProductDto AddProduct(FakeStoreProductDto product) {

//            String title,
//            double price,
//            String description,
//            String category,
//            String imageUrl
//        FakeStoreProductDto product;
//            return product;
        return null;
    };
    public FakeStoreProductDto updateProduct(Long productId, Product product){
        return null;
    }
    public FakeStoreProductDto replaceProduct(Long productId, Product product){
        return null;
    }
    public FakeStoreProductDto Delete(Long productId){
        return null;
    }

}
