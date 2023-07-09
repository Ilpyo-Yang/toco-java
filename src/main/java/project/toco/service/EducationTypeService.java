package project.toco.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.toco.dto.EducationTypeDto;
import project.toco.entity.EducationType;
import project.toco.repository.EducationTypeRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EducationTypeService {
  private final EducationTypeRepository educationTypeRepository;

  public void create(String main, String sub){
    EducationType type = EducationType.createEducationType(main, sub);
    educationTypeRepository.save(type);
  }

  public List<EducationTypeDto> findTypesToDto(){
    return educationTypeRepository.findTypesToDto();
  }

  public List<EducationTypeDto> findTypesToDtoByMain(String main){
    return educationTypeRepository.findTypesToDtoByMain(main);
  }

  public List<String> findMainType() {
    return educationTypeRepository.findMainType();
  }

  public String findUuid(String main, String sub) {
    return educationTypeRepository.findUuidByMainAndSub(main, sub);
  }
}
