package dev.raj.projectstart.inheritanceexamples.inheritance;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class mentor extends User {
  private  int NoofSessions;
  private  int NoOfMentees;
}
