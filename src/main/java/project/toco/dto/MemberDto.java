package project.toco.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberDto {
  private String uuid;
  private String name;
  private String email;
  private String password;
  private String role;
  private LocalDateTime createdDate;
  private LocalDateTime lastModifiedDate;
}
