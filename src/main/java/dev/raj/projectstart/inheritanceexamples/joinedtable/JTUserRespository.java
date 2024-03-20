package dev.raj.projectstart.inheritanceexamples.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JTUserRespository extends JpaRepository<User , Long> {
    User save(User user);

    User findUserById(Long id);
}
