package project.toco.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Education {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  String uuid;
  String name;
  String intro;
  int students;
  int period;
  @Enumerated
  EducationType type;

  @JsonIgnore
  @OneToMany(mappedBy = "education")
  List<Progress> progressList = new ArrayList<>();

  @JsonIgnore
  @OneToMany(mappedBy = "education")
  List<EducationContents> contentslist = new ArrayList<>();
}
