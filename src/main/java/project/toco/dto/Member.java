package project.toco.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Member {
  String uuid;
  String name;
  String email;
  String password;
  String role;
}
