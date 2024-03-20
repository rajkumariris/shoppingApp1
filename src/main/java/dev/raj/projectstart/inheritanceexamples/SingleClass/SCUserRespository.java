package dev.raj.projectstart.inheritanceexamples.SingleClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SCUserRespository extends JpaRepository<User, Long> {
   User save(User user);

    User findUserById(Long id);
}
