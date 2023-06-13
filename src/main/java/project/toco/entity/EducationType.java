package project.toco.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EducationType {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name="type_uuid")
  private String uuid;
  private String main;
  private String sub;

  public static EducationType createEducationType(String main, String sub){
    EducationType educationType = new EducationType();
    educationType.setMain(main);
    educationType.setSub(sub);
    return educationType;
  }
}