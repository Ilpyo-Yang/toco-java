package project.toco.dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.toco.entity.EducationContent;
import project.toco.entity.Status;

@Getter
@Setter
@NoArgsConstructor
public class ProgressDto {
  private String uuid;
  private Status status;
  private String memberUuid;
  private String educationContentUuid;
  private String educationContentName;
  private String educationUuid;
  private String educationName;
  private LocalDate startDate;
  private String mailingDays;
}
