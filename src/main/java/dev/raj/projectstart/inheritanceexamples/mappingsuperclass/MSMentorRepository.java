package dev.raj.projectstart.inheritanceexamples.mappingsuperclass;

import dev.raj.projectstart.inheritanceexamples.mappingsuperclass.mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface MSMentorRepository extends JpaRepository<mentor, Long> {

    mentor save(mentor mentor);



}
