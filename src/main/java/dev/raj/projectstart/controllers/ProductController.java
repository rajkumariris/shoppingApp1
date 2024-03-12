package dev.raj.projectstart.controllers;

import dev.raj.projectstart.dtos.ProductDto;
import dev.raj.projectstart.models.Product;
import dev.raj.projectstart.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController

public class ProductController {

    ProductService productservice;

    public ProductController(ProductService productservice){
        this.productservice = productservice;
    }
    @GetMapping("/products")
    public String getAllProducts(){
        return "get all";
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId, ProductDto productdto ){

        MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();

        headers.add(
                "auth-token","noaccess4auheyhey"
        );
        ResponseEntity<Product> response = new ResponseEntity(
                productservice.getSingleProduct(productId),
                headers,
                HttpStatus.NOT_FOUND

        );
//        getSingleProductResponseDto singleResponse = new getSingleProductResponseDto();
//        singleResponse.setProduct(
//                productservice.getSingleProduct(productId)
//        );




       return response;
    }

    @PostMapping("/products")
    public ResponseEntity<Product> AddProduct(@RequestBody ProductDto product){

               Product newProduct =  productservice.AddProduct(
                        product
                );
               ResponseEntity<Product> responseType = new ResponseEntity<>(
                       newProduct,HttpStatus.OK

               );
                return responseType;
    }
    @PutMapping("/products/{productId}")
    public String updateProduct(@RequestBody ProductDto productdto){
        return " updated Product"+ productdto;
    }
    @DeleteMapping("/products/{productId}")
    public String Delete(@PathVariable("productId") Long productId){
        return " Deleted Product"+ productId;
    }
}
