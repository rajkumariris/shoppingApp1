package dev.raj.projectstart.repositories;

import dev.raj.projectstart.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product);

    Product findProductById(Long Id);

    List<Product> findProductByCatagory_NameAndCatagory_Id(String name, int val);
    Product findByPriceBetween(double greaterThanequal , double lestThnequal);

    @Query(value=Queries.Laao_product_with_Id_query, nativeQuery = true)
    Product laaoProductwithId(Long Id);
}