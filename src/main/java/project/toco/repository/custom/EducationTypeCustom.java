package project.toco.repository.custom;

import java.util.List;
import project.toco.dto.EducationTypeDto;

public interface EducationTypeCustom {
  List<EducationTypeDto> findTypesToDto();
}
