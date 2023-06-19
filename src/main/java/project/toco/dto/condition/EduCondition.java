package project.toco.dto.condition;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EduCondition {
  private int period;
  private int star;
  private String main;
  private String sub;  // type_uuid
}
