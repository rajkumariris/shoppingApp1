package dev.raj.projectstart.inheritanceexamples.SingleClass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("1")
public class instructor  extends User {
    private boolean isHandsome;
}
