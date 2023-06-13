package project.toco.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EducationContent {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name="education_content_uuid")
  private String uuid;
  private int chapter;
  private String name;
  private String details;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="education_uuid")
  private Education education;

  @JsonIgnore
  @OneToMany(mappedBy = "education_content", cascade = CascadeType.ALL)
  private List<Progress> progresses = new ArrayList<>();

  public void addProgress(Progress progress) {
    progresses.add(progress);
    progress.setEducation_content(this);
  }

  public static EducationContent createEducationContents(int chapter, String name, String details){
    EducationContent educationContent = new EducationContent();
    educationContent.setChapter(chapter);
    educationContent.setName(name);
    educationContent.setDetails(details);
    return educationContent;
  }
}
