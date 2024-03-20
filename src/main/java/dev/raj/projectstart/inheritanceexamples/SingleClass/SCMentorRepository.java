package dev.raj.projectstart.inheritanceexamples.SingleClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SCMentorRepository extends JpaRepository<mentor, Long> {

    mentor save(mentor mentor);

    mentor findMentorBy(Long id);

}
