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
  @Column(name="progress_id")
  private String uuid;
  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="member_uuid")
  private Member member;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="education_uuid")
  private Education education;

  public static Progress createProgress(String name, Member member, Education education){
    Progress progress = new Progress();
    progress.setName(name);
    progress.setMember(member);
    progress.setEducation(education);
    return progress;
  }
}
