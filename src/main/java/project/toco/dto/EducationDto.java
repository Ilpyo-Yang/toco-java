package project.toco.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.toco.domain.EducationType;

@Getter
@Setter
@NoArgsConstructor
public class EducationDto {
  String uuid;
  String name;
  String intro;
  int students;
  int period;
  EducationType type;
}
