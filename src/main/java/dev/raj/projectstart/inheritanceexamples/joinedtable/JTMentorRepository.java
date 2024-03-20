package dev.raj.projectstart.inheritanceexamples.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JTMentorRepository extends JpaRepository<mentor, Long> {

    mentor save(mentor mentor);

    mentor findMentorBy(Long id);

}
