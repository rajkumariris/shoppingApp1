package dev.raj.projectstart.inheritanceexamples.tablePerClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tbc_instructor")

public class instructor  extends User{
    private boolean isHandsome;
}
