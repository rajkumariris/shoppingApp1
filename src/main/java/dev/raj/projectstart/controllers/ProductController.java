package dev.raj.projectstart.controllers;

import dev.raj.projectstart.dtos.ProductDto;
import dev.raj.projectstart.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController

public class ProductController {

    ProductService productservice;

    public ProductController(ProductService productservice){
        this.productservice = productservice;
    }
    @GetMapping("/products")
    public String getAllProducts(){
        return "giving all products";
    }

    @GetMapping("/products/{productId}")
    public String getSingleProduct(@PathVariable("productId") Long productId ){
        return "returning Singel product" +productId;
    }

    @PostMapping("/products")
    public String AddProduct(@RequestBody ProductDto productdto){
        return " Added Product"+ productdto;
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
