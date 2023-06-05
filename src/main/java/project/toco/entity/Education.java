package project.toco.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Education extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name="education_id")
  private String uuid;
  private String name;
  private String intro;
  private int students;
  private int period;
  @Enumerated
  private EducationType type;

  @JsonIgnore
  @OneToMany(mappedBy = "education", cascade = CascadeType.ALL)
  private List<Progress> progresses = new ArrayList<>();

  @JsonIgnore
  @OneToMany(mappedBy = "education", cascade = CascadeType.ALL)
  private List<EducationContent> educationContents = new ArrayList<>();

  public void addProgress(Progress progress) {
    progresses.add(progress);
    progress.setEducation(this);
  }

  public void addEducationContents(EducationContent educationContent) {
    educationContents.add(educationContent);
    educationContent.setEducation(this);
  }

  public static Education createEducation(String name, String intro, int students, int period, EducationType type,
                                          List<Progress> progresses, List<EducationContent> educationContents){
    Education education = new Education();
    education.setName(name);
    education.setIntro(intro);
    education.setStudents(students);
    education.setPeriod(period);
    education.setType(type);
    for(Progress progress : progresses){
      education.addProgress(progress);
    }
    for(EducationContent educationContent : educationContents){
      education.addEducationContents(educationContent);
    }
    return education;
  }
}
