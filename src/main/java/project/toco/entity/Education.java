package project.toco.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
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
public class Education extends BaseTimeEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name="education_uuid")
  private String uuid;
  private String name;
  private String intro;
  private int students;
  private int period;
  @Column(name="type_uuid")
  private String type;
  @Enumerated(EnumType.STRING)
  private Level level;

  @JsonIgnore
  @OneToMany(mappedBy = "education", cascade = CascadeType.ALL)
  private List<EducationContent> educationContents = new ArrayList<>();

  @JsonIgnore
  @OneToMany(mappedBy = "education", cascade = CascadeType.ALL)
  private List<EducationScore> educationScores = new ArrayList<>();

  public void addEducationContents(EducationContent educationContent) {
    educationContents.add(educationContent);
    educationContent.setEducation(this);
  }

  public static Education createEducation(String name, String intro, String type_uuid, Level level, List<EducationContent> educationContents){
    Education education = new Education();
    education.setName(name);
    education.setIntro(intro);
    education.setPeriod(educationContents.size());
    education.setType(type_uuid);
    education.setLevel(level);
    for(EducationContent educationContent : educationContents){
      education.addEducationContents(educationContent);
    }
    return education;
  }
}
