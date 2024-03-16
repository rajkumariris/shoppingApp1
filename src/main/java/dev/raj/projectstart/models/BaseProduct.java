package dev.raj.projectstart.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.util.Date;
@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
@MappedSuperclass
public class BaseProduct  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
    private Date createdAt;
    private Date LastUpdatedAt;
    private boolean IsDeleted;

}
