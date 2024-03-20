package dev.raj.projectstart.inheritanceexamples.tablePerClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TPCMentorRepository extends JpaRepository<mentor, Long> {

    mentor save(mentor mentor);

    mentor findMentorBy(Long id);

}
