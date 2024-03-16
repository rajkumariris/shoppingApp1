package dev.raj.projectstart.models;

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
   private Long id;
    private Date createdAt;
    private Date LastUpdatedAt;
    private boolean IsDeleted;

}
