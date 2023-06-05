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
public class EducationContent extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name="education_content_id")
  private String uuid;
  private int order;
  private String name;
  private String details;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="education_uuid")
  private Education education;

  public static EducationContent educationContents(int order, String name, String details, Education education){
    EducationContent educationContent = new EducationContent();
    educationContent.setOrder(order);
    educationContent.setName(name);
    educationContent.setDetails(details);
    educationContent.setEducation(education);
    return educationContent;
  }
}
