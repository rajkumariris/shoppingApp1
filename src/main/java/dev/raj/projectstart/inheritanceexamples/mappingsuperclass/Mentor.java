package dev.raj.projectstart.inheritanceexamples.mappingsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="ms_mentor")
public class Mentor extends User {
  private  int NoofSessions;
  private  int NoOfMentees;
}
