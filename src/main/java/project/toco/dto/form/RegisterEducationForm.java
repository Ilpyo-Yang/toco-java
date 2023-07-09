package project.toco.dto.form;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterEducationForm {
  private String email;
  private LocalDate date;
  private String days;
  private String education_uuid;
}
