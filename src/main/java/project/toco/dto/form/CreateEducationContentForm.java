package project.toco.dto.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateEducationContentForm {
  private String name;
  private String intro;
  private String type;
}
