package dev.raj.projectstart.repositories;

import dev.raj.projectstart.models.Catagories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Catagories ,  Long>{

    Catagories save(Catagories catogory);
}
