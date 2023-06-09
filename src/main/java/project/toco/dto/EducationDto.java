package project.toco.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.toco.entity.EducationType;

@Getter
@Setter
@NoArgsConstructor
public class EducationDto {
  private String uuid;
  private String name;
  private String intro;
  private int students;
  private int period;
  private String type;
  private LocalDateTime createdDate;
  private LocalDateTime lastModifiedDate;
}
