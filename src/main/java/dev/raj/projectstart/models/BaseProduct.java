package dev.raj.projectstart.models;

import lombok.*;

import java.util.Date;
@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class BaseProduct  {
    private Long id;
    private Date createdAt;
    private Date LastUpdatedAt;
    private boolean IsDeleted;

}
