package project.toco.repository.custom;

import java.util.List;
import project.toco.dto.EducationContentDto;
import project.toco.entity.Education;
import project.toco.entity.EducationContent;

public interface EducationContentCustom {
  EducationContent getNextUuid(int nextChapter, Education education);
  List<EducationContentDto> findAllToDto(Education education);
}
