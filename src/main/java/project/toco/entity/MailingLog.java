package project.toco.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MailingLog {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name="mailing_log_uuid")
  private String uuid;
  private String receiver;
  private String history;
  @CreatedDate
  private LocalDateTime sentDate;

  public static MailingLog createMember(String member_uuid, String history){
    MailingLog mailingLog = new MailingLog();
    mailingLog.setReceiver(member_uuid);
    mailingLog.setHistory(history);
    //mailingLog.setSentDate(LocalDateTime.now());
    return mailingLog;
  }
}
