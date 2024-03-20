package dev.raj.projectstart.inheritanceexamples.mappingsuperclass;

import dev.raj.projectstart.inheritanceexamples.mappingsuperclass.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MSUserRespository extends JpaRepository<User, Long> {

    User findUserById(Long id);


}
