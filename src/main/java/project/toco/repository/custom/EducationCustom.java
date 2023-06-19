package project.toco.repository.custom;

import java.util.List;
import project.toco.dto.EducationDto;
import project.toco.dto.condition.EduCondition;

public interface EducationCustom {
  EducationDto findOneEduToDto(String uuid);
  List<EducationDto> findAllToDto(EduCondition eduCondition);
}
