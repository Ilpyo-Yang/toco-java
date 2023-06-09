package project.toco.repository.custom;

import java.util.List;
import project.toco.dto.EducationTypeDto;

public interface EducationRepositoryCustom {

  /* EducationType */
  List<EducationTypeDto> findTypesToDto();
}
