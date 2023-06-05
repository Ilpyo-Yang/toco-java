package project.toco.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProgressDto {
  private String uuid;
  private String name;
  private String createdBy;
  private String lastModifiedBy;
  private LocalDateTime createdDate;
  private LocalDateTime lastModifiedDate;
}
