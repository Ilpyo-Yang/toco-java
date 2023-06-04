package project.toco.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Education {
  @Id
  String uuid;
  String name;
  String explain;
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
