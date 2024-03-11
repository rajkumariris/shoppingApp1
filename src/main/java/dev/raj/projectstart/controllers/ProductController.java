package dev.raj.projectstart.controllers;

import dev.raj.projectstart.dtos.ProductDto;
import org.springframework.web.bind.annotation.*;

@RestController

public class ProductController {

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
    public String updateProduct(@PathVariable("productId") Long productId){
        return " updated Product"+ productId;
    }
    @DeleteMapping("/products/{productId}")
    public String Delete(@PathVariable("productId") Long productId){
        return " Deleted Product"+ productId;
    }
}
