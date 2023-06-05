package project.toco.entity;

import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum EducationType {
  CS("CS", Arrays.asList("CS","Architecture","Algorithm"))
  ,Backend("백엔드", Arrays.asList("Java","Python","Kotlin","C#"))
  ,Frontend("프론트엔드", Arrays.asList("JS","React","Typescript"))
  ,Devops("데브옵스", Arrays.asList("Network","AWS"))
  ,Tool("툴", Arrays.asList("GitHub","IntelliJ"));

  private final String name;
  private final List<String> list;

  EducationType(String name, List<String> list) {
    this.name = name;
    this.list = list;
  }
}
