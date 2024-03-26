package dev.raj.projectstart;

import dev.raj.projectstart.models.Catagories;
import dev.raj.projectstart.models.Product;
import dev.raj.projectstart.repositories.CategoryRepository;
import dev.raj.projectstart.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@SpringBootTest
public class ProductTest {
    @Autowired
    ProductRepository productrepository;
    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void productfetching(){

        Catagories catagory = new Catagories();
        catagory.setName("electronics");
//Catagories savedcatagoryy =  categoryRepository.save(catagory);

        Product product = new Product();
         product.setPrice(100);
         product.setImageUrl("hello");
         product.setCatagory(catagory);
         productrepository.save(product);
    }

    @Test
    void fetchaProduct(){
       Product product =  productrepository.findProductById(1L);
        System.out.println("debug");
    }
    @Test
    @Transactional
    @Rollback(value = false)
    void getProductById(){
        Catagories catagory = categoryRepository.findById(1L).get();

        Product product = new Product();
        product.setPrice(1012);
        product.setImageUrl("hilll");
        product.setCatagory(catagory);
        productrepository.save(product);

        Product product1 = new Product();
        product1.setPrice(101);
        product1.setImageUrl("jacket");
        product1.setCatagory(catagory);
        productrepository.save(product1);




    }
    @Test
    @Transactional
    void getAllproduct(){
        List<Catagories> catagory =  categoryRepository.findAllByIdIn(List.of(1L,2L));
        for(Catagories catagory1 : catagory){
            for(Product product : catagory1.getProducts()){
                System.out.println(product.getPrice());
            }

        }
    }
    @Test
    void demostrateProduct(){
        List<Product> products = productrepository.getByIdAndName(1L,"hi");
    }


}
