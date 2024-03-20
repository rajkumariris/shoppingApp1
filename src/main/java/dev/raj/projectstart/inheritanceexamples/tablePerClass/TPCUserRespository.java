package dev.raj.projectstart.inheritanceexamples.tablePerClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface TPCUserRespository extends JpaRepository<User, Long> {
    User save(User user);
    User findUserById(Long id);
}
