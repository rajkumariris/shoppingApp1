package dev.raj.projectstart.repositories;

import dev.raj.projectstart.models.Catagories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.LongSummaryStatistics;

public interface CategoryRepository extends JpaRepository<Catagories ,  Long>{

    Catagories save(Catagories catogory);

    List<Catagories> findAllByIdIn(List<Long> ids);


}
