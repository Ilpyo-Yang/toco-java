package project.toco.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EducationContentDto {
  private String uuid;
  private int chapter;
  private String name;
  private String intro;
  private String details;
  private String education_uuid;
}
