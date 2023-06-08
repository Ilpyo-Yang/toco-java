package project.toco.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
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
public class EducationType {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name="type_uuid")
  private String uuid;
  @NotNull
  private String main;
  @NotNull
  private String sub;

  public static EducationType createEducationType(String main, String sub){
    EducationType educationType = new EducationType();
    educationType.setMain(main);
    educationType.setSub(sub);
    return educationType;
  }
}