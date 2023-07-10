package project.toco.repository.custom;

import java.util.List;
import project.toco.dto.EducationTypeDto;

public interface EducationTypeCustom {
  List<EducationTypeDto> findTypesToDto();
  List<EducationTypeDto> findTypesToDtoByMain(String main);
  List<String> findMainType();
  List<String> findUuidByMainAndSub(String main, String sub);
}
