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
public class EducationScore {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name="education_score_uuid")
  private String uuid;
  private int score;
  private String member_uuid;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="education_uuid")
  private Education education;

  public static EducationScore createEducationScore(String education_uuid, String member_uuid, int score, Education education){
    EducationScore educationContent = new EducationScore();
    educationContent.setEducation(education);
    educationContent.setMember_uuid(member_uuid);
    educationContent.setScore(score);
    return educationContent;
  }
}
