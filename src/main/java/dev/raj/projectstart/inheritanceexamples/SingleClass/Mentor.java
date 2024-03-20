package dev.raj.projectstart.inheritanceexamples.SingleClass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("3")
public class Mentor extends User {
  private  int NoofSessions;
  private  int NoOfMentees;
}
