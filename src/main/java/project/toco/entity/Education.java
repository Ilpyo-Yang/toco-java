package project.toco.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Education extends BaseTimeEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name="education_uuid")
  private String uuid;
  @NotNull
  private String name;
  @NotNull
  private String intro;
  @NotNull
  private int students;
  @NotNull
  private int period;
  @NotNull
  @Column(name="type_uuid")
  private String type;

  @JsonIgnore
  @OneToMany(mappedBy = "education", cascade = CascadeType.ALL)
  private List<EducationContent> educationContents = new ArrayList<>();

  public void addEducationContents(EducationContent educationContent) {
    educationContents.add(educationContent);
    educationContent.setEducation(this);
  }

  public static Education createEducation(String name, String intro, String type_uuid, List<EducationContent> educationContents){
    Education education = new Education();
    education.setName(name);
    education.setIntro(intro);
    education.setPeriod(educationContents.size());
    education.setType(type_uuid);
    for(EducationContent educationContent : educationContents){
      education.addEducationContents(educationContent);
    }
    return education;
  }
}
