package project.toco.repository.custom;

import java.util.List;
import project.toco.dto.EducationContentDto;
import project.toco.entity.Education;

public interface EducationContentCustom {
  String getNextUuid(int nextChapter, Education education);
  List<EducationContentDto> findAllToDto();
}
