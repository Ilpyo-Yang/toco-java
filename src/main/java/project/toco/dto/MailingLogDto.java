package project.toco.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MailingLogDto {
  private String uuid;
  private String receiver;
  private String history;
  private LocalDateTime sentDate;
}
