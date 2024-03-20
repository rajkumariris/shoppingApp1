package dev.raj.projectstart.inheritanceexamples.SingleClass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="ta_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "user_type",
        discriminatorType = DiscriminatorType.INTEGER
)
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
//   @Column(name = "id", nullable = false)
   private Long id;
   private String email;
   private String password;
}
