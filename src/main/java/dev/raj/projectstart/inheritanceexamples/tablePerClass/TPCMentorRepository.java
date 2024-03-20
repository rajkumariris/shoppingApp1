package dev.raj.projectstart.inheritanceexamples.tablePerClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TPCMentorRepository extends JpaRepository<Mentor, Long> {

    Mentor save(Mentor mentor);

 //   Mentor findMentorBy(Long id);

}
