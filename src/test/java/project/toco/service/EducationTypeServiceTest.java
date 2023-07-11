package project.toco.service;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import project.toco.dto.EducationTypeDto;
import project.toco.entity.EducationType;
import project.toco.repository.EducationTypeRepository;

@SpringBootTest
@Transactional
class EducationTypeServiceTest {
  @Autowired
  EducationTypeRepository educationTypeRepository;

  @Test
  void create() {
    String main = "main";
    String sub = "sub";
    EducationType educationType = EducationType.createEducationType(main, sub);
    educationTypeRepository.save(educationType);
    assert educationType.getUuid().equals(educationTypeRepository.findUuidByMainAndSub(main,sub).get(0));
  }

  @Test
  void findTypesToDto() {
    List<EducationType> list = educationTypeRepository.findAll();
    List<EducationTypeDto> educationTypeDtos = educationTypeRepository.findTypesToDto();
    assert list.size() == educationTypeDtos.size();
  }

  @Test
  void findTypesToDtoByMain() {
    String main = "CS";
    List<EducationType> list = educationTypeRepository.findAll();
    list = list.stream().filter(f -> f.getMain().equals(main)).collect(Collectors.toList());
    assert list.size() == educationTypeRepository.findTypesToDtoByMain(main).size();
  }

  @Test
  void findMainType() {
    List<String> list = educationTypeRepository.findMainType();
    List<EducationType> educationTypes = educationTypeRepository.findAll();
    for(EducationType type:educationTypes){
      if(!educationTypes.contains(type)) assert false;
    }
    assert true;
  }

  // create() 로직에서 test 확인
  @Test
  void findUuidByMainAndSub() {
  }
}