package dev.raj.projectstart.controllers;

import dev.raj.projectstart.dtos.ProductDto;
import dev.raj.projectstart.exceptions.NotFoundException;
import dev.raj.projectstart.models.Catagories;
import dev.raj.projectstart.models.Product;
import dev.raj.projectstart.repositories.ProductRepository;
import dev.raj.projectstart.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class ProductController {

    ProductService productservice;
    ProductRepository productrepo;
    public ProductController(ProductService productservice,ProductRepository productrepo){
        this.productservice = productservice;
        this.productrepo = productrepo;
    }
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productservice.getAllProducts();
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId, ProductDto productdto ) throws  NotFoundException{

        MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();

        headers.add(
                "auth-token","noaccess4auheyhey"
        );

        Optional<Product> productOptional = productservice.getSingleProduct(productId);
          if(productOptional.isEmpty()){
              throw new NotFoundException("No Product with"+ productId);
          }


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

//               Product newProduct =  productservice.AddProduct(
//                        product
//                );

        Product newProduct = new Product();
        newProduct.setDescription(product.getDescription());
        newProduct.setImageUrl(product.getImage());
        newProduct.setTitle(product.getTitle());
        newProduct.setPrice(product.getPrice());

         productrepo.save(newProduct);
               ResponseEntity<Product> responseType = new ResponseEntity<>(
                       newProduct,HttpStatus.OK
               );
                return responseType;
    }
    @PatchMapping("/products/{productId}")
    public Product updateProduct(@PathVariable("productId") Long productId,
                                    @RequestBody ProductDto productdto){
         Product product = new Product();
        // product.setId(productdto.getId());
         product.setCatagory(new Catagories());
         product.getCatagory().setName(productdto.getCatagory());
         product.setTitle(productdto.getTitle());

        return productservice.updateProduct(productId, product);
    }
    @DeleteMapping("/products/{productId}")
    public String Delete(@PathVariable("productId") Long productId){
        return " Deleted Product"+ productId;
    }



}