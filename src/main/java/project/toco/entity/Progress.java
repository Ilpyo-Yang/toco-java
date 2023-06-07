package project.toco.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Progress extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name="progress_uuid")
  private String uuid;
  private Status status;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="member_uuid")
  private Member member;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="education_content_uuid")
  private EducationContent education_content;

  public static Progress createProgress(Status status, Member member, EducationContent educationContent){
    Progress progress = new Progress();
    progress.setStatus(status);
    progress.setMember(member);
    progress.setEducation_content(educationContent);
    return progress;
  }
}
