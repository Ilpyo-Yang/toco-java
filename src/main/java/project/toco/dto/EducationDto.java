package project.toco.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.toco.entity.Level;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EducationDto {
  private String uuid;
  private String name;
  private String intro;
  private int students;
  private int period;
  private long score;
  private String type;
  private Level level;
  private LocalDateTime createdDate;
  private LocalDateTime lastModifiedDate;
}
