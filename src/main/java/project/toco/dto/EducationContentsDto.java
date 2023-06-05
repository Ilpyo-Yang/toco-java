package project.toco.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EducationContentsDto {
  private String uuid;
  private String name;
  private String details;
  private String createdBy;
  private String lastModifiedBy;
  private LocalDateTime createdDate;
  private LocalDateTime lastModifiedDate;
}
