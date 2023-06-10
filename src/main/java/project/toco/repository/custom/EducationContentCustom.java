package project.toco.repository.custom;

import project.toco.entity.Education;

public interface EducationContentCustom {

  String getNextUuid(int nextChapter, Education education);
}
