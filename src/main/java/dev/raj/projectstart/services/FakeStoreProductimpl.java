package dev.raj.projectstart.services;

import dev.raj.projectstart.dtos.FakeStoreProductDto;
import dev.raj.projectstart.dtos.ProductDto;
import dev.raj.projectstart.models.Catagories;
import dev.raj.projectstart.models.Product;
import jdk.jfr.Category;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class FakeStoreProductimpl implements ProductService {
    private RestTemplateBuilder resttemplatebuilder;

    public FakeStoreProductimpl(RestTemplateBuilder restTemplateBuilder){
        this.resttemplatebuilder = restTemplateBuilder;
    }


    private  <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request,
                                                    Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = resttemplatebuilder.requestFactory(
            HttpComponentsClientHttpRequestFactory.class
        ).build();

        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
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
    public Optional<Product> getSingleProduct(Long productId) {

        RestTemplate restTemple = resttemplatebuilder.build();
        ResponseEntity<FakeStoreProductDto> response =  restTemple.getForEntity("https://fakestoreapi.com/products/{id}", FakeStoreProductDto.class, productId);
        FakeStoreProductDto productDto = response.getBody();

        if(productDto ==null){
            return Optional.empty();
        }
        return Optional.of(converttoProduct(productDto));

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
    public Product updateProduct(Long productId, Product product) {

        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setCatagory(product.getCatagory().getName());

        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity= requestForEntity(
                HttpMethod.PATCH,
                "https://fakestoreapi.com/products/{id}",
                fakeStoreProductDto,
                FakeStoreProductDto.class,
                productId
                );

        return converttoProduct(fakeStoreProductDtoResponseEntity.getBody());
    }

   public String replaceProduct(Long productId, Product product){
        return "hi";
    }

    @Override
    public String Delete(Long productId) {
        return null;
    }
}
