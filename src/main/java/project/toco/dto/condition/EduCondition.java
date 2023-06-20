package project.toco.dto.condition;

import java.util.List;
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
  private List<String> type;
}
