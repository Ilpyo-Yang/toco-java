package project.toco.dto.condition;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.toco.entity.Level;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EduCondition {
  private int period;
  private int star;
  private Level level;
  private String type_uuid;
}
