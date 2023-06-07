package project.toco.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.toco.entity.Status;

@Getter
@Setter
@NoArgsConstructor
public class ProgressDto {
  private String uuid;
  private Status status;
  private String member_uuid;
  private String education_content_uuid;
  private String createdBy;
  private String lastModifiedBy;
  private LocalDateTime createdDate;
  private LocalDateTime lastModifiedDate;
}
