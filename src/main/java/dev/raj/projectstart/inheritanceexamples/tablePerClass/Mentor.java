package dev.raj.projectstart.inheritanceexamples.tablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tbc_mentor")
public class Mentor extends User{
  private  int NoofSessions;
  private  int NoOfMentees;
}
