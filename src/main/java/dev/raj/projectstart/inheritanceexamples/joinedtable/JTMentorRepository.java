package dev.raj.projectstart.inheritanceexamples.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JTMentorRepository extends JpaRepository<Mentor, Long> {

    Mentor save(Mentor mentor);

   // Mentor findMentorBy(Long id);

}
