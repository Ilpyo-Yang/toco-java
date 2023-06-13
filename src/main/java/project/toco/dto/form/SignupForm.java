package project.toco.dto.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SignupForm {
  private String name;
  private String email;
  private String password;
  private String role;
}
