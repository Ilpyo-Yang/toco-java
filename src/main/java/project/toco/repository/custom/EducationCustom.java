package project.toco.repository.custom;

import java.util.List;
import project.toco.dto.EducationDto;

public interface EducationCustom {
  EducationDto findOneEduToDto(String uuid);
  List<EducationDto> findAllToDto();
}
